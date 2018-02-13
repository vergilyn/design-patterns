package com.vergilyn.examples.design.creational.singleton.singleton_07;

/**
 * 单例模式07：双重校验锁。
 * @author VergiLyn
 * @bolg http://www.cnblogs.com/VergiLyn/
 * @date 2016/12/20
 */
public class DualSync {
    private volatile static DualSync instance;

    private DualSync(){}

    public static DualSync getInstance(){
        if(instance == null){
            synchronized (DualSync.class){
                if(instance == null){
                    instance = new DualSync();
                }
            }
        }
        return instance;
    }
}
