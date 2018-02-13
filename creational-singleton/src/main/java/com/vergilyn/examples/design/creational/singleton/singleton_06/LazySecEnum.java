package com.vergilyn.examples.design.creational.singleton.singleton_06;

import com.alibaba.fastjson.JSON;

/**
 * 单例模式06：利用枚举。<br/>
 * "这种方式是Effective Java作者Josh Bloch提倡的方式,避免多线程同步的同时,还能防止反序列化重新创建新的对象."
 * @author VergiLyn
 * @bolg http://www.cnblogs.com/VergiLyn/
 * @date 2016/12/20
 */
public enum LazySecEnum {
    INSTANCE;
    public void anyMethod(){
        //some code...
    }
}

class test{
    public static void main(String[] args) throws Exception {
        LazySecEnum s3 = JSON.parseObject("{'1':'a1'}",LazySecEnum.class);
        System.out.println(s3);

    }
}