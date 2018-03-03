package com.vergilyn.examples.design.integration.observer;

/**
 * 抽象观察者
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/
 * @date 2018/2/16
 */
public interface AbstractObserver {
    String name();
    void onMessage(AbstractSubject subject, String msg);
}
