package com.vergilyn.examples.design.integration.observer;

/**
 * 场景: subject[微信公众号]，observer[微信用户]。当公众号更新时，将更新信息[message]通知所有的观察者。
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/
 * @date 2018/2/16
 */
public class TestObserver {
    public static void main(String[] args) {
        AbstractSubject subject = new Subject("公众号-01");

        AbstractObserver observer1 = new Observer("user-01");
        AbstractObserver observer2 = new Observer("user-02");
        AbstractObserver observer3 = new Observer("user-03");

        subject.add(observer1);
        subject.add(observer2);
        subject.add(observer3);

        subject.publishMessage("some message");
    }
}
