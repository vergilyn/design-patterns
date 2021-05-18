package com.vergilyn.examples.design.pubsub;

import java.util.concurrent.ConcurrentMap;

import com.google.common.collect.Maps;

/**
 * @author vergilyn
 * @date 2021-01-26
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
		entries.forEach((key, subscribe) -> {
			System.out.println("message >>>> " + subscribe.getKey());
		});
	}
}
