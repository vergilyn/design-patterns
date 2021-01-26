package com.vergilyn.examples.design.observer;

/**
 * 具体观察者
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class Observer implements AbstractObserver {
    private final String name;

    public Observer(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    public void onMessage(AbstractSubject subject, String msg) {
        System.out.println(String.format("observer[%s]: subject[%s], message[%s]", name, subject.name(), msg));
    }
}
