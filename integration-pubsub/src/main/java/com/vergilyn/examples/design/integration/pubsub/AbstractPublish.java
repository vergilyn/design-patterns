package com.vergilyn.examples.design.integration.pubsub;

/**
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/
 * @date 2018/2/16
 */
public interface AbstractPublish {

    void add(AbstractSubscribe subscribe);

    void del(AbstractSubscribe subscribe);

    void onMessage();
}
