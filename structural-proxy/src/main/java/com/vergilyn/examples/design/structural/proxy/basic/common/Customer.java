package com.vergilyn.examples.design.structural.proxy.basic.common;

/**
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/
 * @date 2017/8/8
 */
public class Customer implements CustomerAbstract{
    public final static String SIMPLE_DESC = "我要换显卡.";
    public final static String DETAIL_DESC = "我要换1080ti显卡.";

    public Customer(){}

    public Customer(long sleepMillis){
        System.out.println("Customer(long sleepMillis) init begin.");
        try {
            long begin = System.currentTimeMillis();
            Thread.sleep(sleepMillis);
            long end = System.currentTimeMillis();
            System.out.println("Customer init end: " + end + " - " + begin + " = " + (end - begin));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void exchange() {
        System.out.println("Customer: " + SIMPLE_DESC);
    }
}
