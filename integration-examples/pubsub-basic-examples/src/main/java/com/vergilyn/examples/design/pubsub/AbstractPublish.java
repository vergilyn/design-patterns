package com.vergilyn.examples.design.pubsub;

/**
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public interface AbstractPublish {

    void add(AbstractSubscribe subscribe);

    void del(AbstractSubscribe subscribe);

    void onMessage();
}
