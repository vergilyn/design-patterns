package com.vergilyn.examples.design.proxy.kinds;

import java.lang.reflect.Proxy;

import com.vergilyn.examples.design.proxy.common.Customer;
import com.vergilyn.examples.design.proxy.common.CustomerAbstract;

/**
 * jdk动态代理原理: 根据 classLoader和interfaces, 创建代理类.
 * 此代理类是接口的实现类，所以必须使用接口.
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class JdkProxy {

    public static CustomerAbstract proxy(Customer customer){
        return (CustomerAbstract) Proxy.newProxyInstance(
                customer.getClass().getClassLoader()
                , customer.getClass().getInterfaces()
                , (pro,method, params) -> {
                    Object invoke = method.invoke(customer, params);
                    System.out.println("JdkProxy: " + Customer.DETAIL_DESC);
                    return invoke;

                });
    }

}
