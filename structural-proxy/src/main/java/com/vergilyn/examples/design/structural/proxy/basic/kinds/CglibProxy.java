package com.vergilyn.examples.design.structural.proxy.basic.kinds;

import java.lang.reflect.Method;

import com.vergilyn.examples.design.structural.proxy.basic.common.Customer;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 如果目标对象没有实现接口，用Cglib代理;
 * <p>
 *   1. 需要引入cglib的jar文件.<br/>
 *   2. 目标类不能为final.<br/>
 *   3. 目标对象的方法如果为final/static，那么就不会被拦截，即不会执行目标对象额外的业务方法.<br/>
 *   4. 注意目标对象是否存在: 无参构造函数.<br/>
 * <p/>
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/
 * @date 2017/8/8
 */
public class CglibProxy implements MethodInterceptor {
    // 维护目标对象
    private Object target;

    public CglibProxy(Object target) {
        this.target = target;
    }

    // 给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象), 需无参构造函数(不存在无参构造函数: en.create(Class[] argumentTypes, Object[] arguments))
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object invoke = method.invoke(target, args);
        System.out.println("CglibProxy: " + Customer.DETAIL_DESC);
        return invoke;
    }
}
