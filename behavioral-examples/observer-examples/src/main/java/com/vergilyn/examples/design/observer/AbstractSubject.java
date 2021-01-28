package com.vergilyn.examples.design.observer;

/**
 * 抽象主题
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public interface AbstractSubject {
	String name();

	void add(AbstractObserver observer);

	void del(AbstractObserver observer);

	void publishMessage(String message);
}
