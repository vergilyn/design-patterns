package com.vergilyn.examples.design.integration.pubsub;

/**
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/
 * @date 2018/2/16
 */
public class PubSubTest {
    public static void main(String[] args) {
        Publish publish = new Publish();

        Subscribe sb1 = new Subscribe("sb1");
        Subscribe sb2 = new Subscribe("sb2");
        Subscribe sb3 = new Subscribe("sb3");

        publish.add(sb1);
        publish.add(sb2);
        publish.add(sb3);


    }
}
