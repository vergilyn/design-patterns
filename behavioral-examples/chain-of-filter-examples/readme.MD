# chain-of-filter-examples

> [廖雪峰 - 责任链模式](https://www.liaoxuefeng.com/wiki/1252599548343744/1281319474561057)
> 还有一些责任链模式，每个Handler都有机会处理Request，  
> 通常这种责任链被称为拦截器（Interceptor）或者过滤器（Filter），  
> 它的目的不是找到某个Handler处理掉Request，而是每个Handler都做一些工作。

例如：
1. servlet filter, 它不但允许每个Filter都有机会处理请求，还**允许每个Filter决定是否将请求“放行”给下一个Filter**。
2. dubbo filter, 它允许每个Filter处理请求，并且将请求“放行”给下一个Filter。

主要参考dubbo-filter：
1. 通过next，保存下一个filter，并在处理完成后，调用`next.handler()`进行传递。

```JAVA
@SPI
public interface Filter {
    /**
     * Make sure call invoker.invoke() in your implementation.
     */
    Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException;

    interface Listener {

        void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation);

        void onError(Throwable t, Invoker<?> invoker, Invocation invocation);
    }

}
```

```JAVA
public class MonitorFilter implements Filter, Filter.Listener {
    
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        if (invoker.getUrl().hasParameter(MONITOR_KEY)) {
            invocation.put(MONITOR_FILTER_START_TIME, System.currentTimeMillis());
            getConcurrent(invoker, invocation).incrementAndGet(); // count up
        }
        return invoker.invoke(invocation); // proceed invocation chain
    }
    
    @Override
    public void onResponse(Result result, Invoker<?> invoker, Invocation invocation) {
        if (invoker.getUrl().hasParameter(MONITOR_KEY)) {
            collect(invoker, invocation, result, RpcContext.getContext().getRemoteHost(), (long) invocation.get(MONITOR_FILTER_START_TIME), false);
            getConcurrent(invoker, invocation).decrementAndGet(); // count down
        }
    }

    @Override
    public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {
        if (invoker.getUrl().hasParameter(MONITOR_KEY)) {
            collect(invoker, invocation, null, RpcContext.getContext().getRemoteHost(), (long) invocation.get(MONITOR_FILTER_START_TIME), true);
            getConcurrent(invoker, invocation).decrementAndGet(); // count down
        }
    }
}
```

```JAVA
public class AccessLogFilter implements Filter, Filter.Listener {
	
	@Override
    public Result invoke(Invoker<?> invoker, Invocation inv) throws RpcException {
        try {
            String accessLogKey = invoker.getUrl().getParameter(ACCESS_LOG_KEY);
            if (ConfigUtils.isNotEmpty(accessLogKey)) {
                AccessLogData logData = buildAccessLogData(invoker, inv);
                log(accessLogKey, logData);
            }
        } catch (Throwable t) {
            logger.warn("Exception in AccessLogFilter of service(" + invoker + " -> " + inv + ")", t);
        }
        return invoker.invoke(inv);
    }
}
```

```java
public class ProtocolFilterWrapper implements Protocol {
	
	private static <T> Invoker<T> buildInvokerChain(final Invoker<T> invoker, String key, String group) {
        Invoker<T> last = invoker;
        List<Filter> filters = ExtensionLoader.getExtensionLoader(Filter.class).getActivateExtension(invoker.getUrl(), key, group);

        if (!filters.isEmpty()) {
            for (int i = filters.size() - 1; i >= 0; i--) {
                final Filter filter = filters.get(i);
                final Invoker<T> next = last;
                last = new Invoker<T>() {

                    @Override
                    public Class<T> getInterface() {
                        return invoker.getInterface();
                    }

                    @Override
                    public URL getUrl() {
                        return invoker.getUrl();
                    }

                    @Override
                    public boolean isAvailable() {
                        return invoker.isAvailable();
                    }

                    @Override
                    public Result invoke(Invocation invocation) throws RpcException {
                        Result asyncResult;
                        try {
                            asyncResult = filter.invoke(next, invocation);
                        } catch (Exception e) {
                            if (filter instanceof ListenableFilter) {
                                ListenableFilter listenableFilter = ((ListenableFilter) filter);
                                try {
                                    Filter.Listener listener = listenableFilter.listener(invocation);
                                    if (listener != null) {
                                        listener.onError(e, invoker, invocation);
                                    }
                                } finally {
                                    listenableFilter.removeListener(invocation);
                                }
                            } else if (filter instanceof Filter.Listener) {
                                Filter.Listener listener = (Filter.Listener) filter;
                                listener.onError(e, invoker, invocation);
                            }
                            throw e;
                        } finally {

                        }
                        return asyncResult.whenCompleteWithContext((r, t) -> {
                            if (filter instanceof ListenableFilter) {
                                ListenableFilter listenableFilter = ((ListenableFilter) filter);
                                Filter.Listener listener = listenableFilter.listener(invocation);
                                try {
                                    if (listener != null) {
                                        if (t == null) {
                                            listener.onResponse(r, invoker, invocation);
                                        } else {
                                            listener.onError(t, invoker, invocation);
                                        }
                                    }
                                } finally {
                                    listenableFilter.removeListener(invocation);
                                }
                            } else if (filter instanceof Filter.Listener) {
                                Filter.Listener listener = (Filter.Listener) filter;
                                if (t == null) {
                                    listener.onResponse(r, invoker, invocation);
                                } else {
                                    listener.onError(t, invoker, invocation);
                                }
                            }
                        });
                    }

                    @Override
                    public void destroy() {
                        invoker.destroy();
                    }

                    @Override
                    public String toString() {
                        return invoker.toString();
                    }
                };
            }
        }

        return last;
    }
}
```

## discuss, Chain-of-Filter vs Template-Method
比如，记录请求 -> 解析文件 -> 保存数据。

模版方法**更强调**执行顺序。责任链虽然也考虑执行顺序，但相对而言要弱一点。
