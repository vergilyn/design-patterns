package com.vergilyn.examples.design.integration.observer;

import java.util.Set;

import com.google.common.collect.Sets;

/**
 * 具体主题（具体被观察者）
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/
 * @date 2018/2/16
 */
public class Subject implements AbstractSubject {
    private final Set<AbstractObserver> observers = Sets.newLinkedHashSet();

    private final String name;

    public Subject(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void add(AbstractObserver observer) {
        observers.add(observer);
    }

    @Override
    public void del(AbstractObserver observer) {
        observers.remove(observer);
    }


    @Override
    public void publishMessage(String message) {
        for (AbstractObserver observer : observers){
            observer.onMessage(this, message);
        }
    }

}
