package com.vergilyn.examples.design.pubsub;

/**
 *
 * @author vergilyn
 * @date 2021-01-26
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
