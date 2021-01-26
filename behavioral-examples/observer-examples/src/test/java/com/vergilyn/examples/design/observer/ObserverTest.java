package com.vergilyn.examples.design.observer;

import java.util.concurrent.CountDownLatch;

import org.junit.jupiter.api.Test;

/**
 * 场景: subject[微信公众号]，observer[微信用户]。当公众号更新时，将更新信息[message]通知所有的观察者。
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class ObserverTest {

    @Test
    public void test() throws InterruptedException {
        AbstractSubject subject = new Subject("公众号-01");

        AbstractObserver observer1 = new Observer("user-01");
        AbstractObserver observer2 = new Observer("user-02");
        AbstractObserver observer3 = new Observer("user-03");

        subject.add(observer1);
        subject.add(observer2);
        subject.add(observer3);

        subject.publishMessage("some message");

        new CountDownLatch(1).await();
    }
}
