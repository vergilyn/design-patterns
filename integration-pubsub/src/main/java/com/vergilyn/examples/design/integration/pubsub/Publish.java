package com.vergilyn.examples.design.integration.pubsub;

import java.util.concurrent.ConcurrentMap;

import com.google.common.collect.Maps;

/**
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/
 * @date 2018/2/16
 */
public class Publish implements AbstractPublish {
    private final ConcurrentMap<String, AbstractSubscribe> entries = Maps.newConcurrentMap();


    @Override
    public void add(AbstractSubscribe subscribe) {
        entries.putIfAbsent(subscribe.getKey(), subscribe);
    }

    @Override
    public void del(AbstractSubscribe subscribe) {
        entries.remove(subscribe.getKey());
    }

    @Override
    public void onMessage() {

    }
}
