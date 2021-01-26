package com.vergilyn.examples.design.observer;

/**
 * 抽象观察者
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public interface AbstractObserver {
    String name();
    void onMessage(AbstractSubject subject, String msg);
}
