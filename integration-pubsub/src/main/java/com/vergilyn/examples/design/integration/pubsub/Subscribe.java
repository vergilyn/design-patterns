package com.vergilyn.examples.design.integration.pubsub;

/**
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/
 * @date 2018/2/16
 */
public class Subscribe implements AbstractSubscribe {

    private String key;

    public Subscribe(String key) {
        this.key = key;
    }

    @Override
    public String getKey() {
        return key;
    }
}
