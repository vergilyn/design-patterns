package com.vergilyn.examples.design.pubsub;

import org.junit.jupiter.api.Test;

/**
 * @author vergilyn
 * @date 2021-01-26
 */
public class PubSubTest {

	@Test
	public void test() throws InterruptedException {
		Publish publish = new Publish();

		Subscribe sb1 = new Subscribe("sb1");
		Subscribe sb2 = new Subscribe("sb2");
		Subscribe sb3 = new Subscribe("sb3");

		publish.add(sb1);
		publish.add(sb2);
		publish.add(sb3);

		publish.onMessage();
	}
}
