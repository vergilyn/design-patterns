package com.vergilyn.examples.design.integration.observer;

/**
 * 抽象主题
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/
 * @date 2018/2/16
 */
public interface AbstractSubject {
    String name();
    void add(AbstractObserver observer);
    void del(AbstractObserver observer);
    void publishMessage(String message);
}
