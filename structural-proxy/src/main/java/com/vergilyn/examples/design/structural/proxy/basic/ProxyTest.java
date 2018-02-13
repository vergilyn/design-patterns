package com.vergilyn.examples.design.structural.proxy.basic;

import com.vergilyn.examples.design.structural.proxy.basic.common.Customer;
import com.vergilyn.examples.design.structural.proxy.basic.common.CustomerAbstract;
import com.vergilyn.examples.design.structural.proxy.basic.kinds.CglibProxy;
import com.vergilyn.examples.design.structural.proxy.basic.kinds.JdkProxy;
import com.vergilyn.examples.design.structural.proxy.basic.kinds.StaticProxy;

/**
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/
 * @date 2017/8/8
 */
public class ProxyTest {
    public static void main(String[] args) {
        Customer customer = new Customer();

        StaticProxy staticProxy = new StaticProxy(customer);
        staticProxy.exchange();
        System.out.println("==========================================");

        CustomerAbstract jdkProxy = JdkProxy.proxy(customer);
        jdkProxy.exchange();
        System.out.println("==========================================");

        CglibProxy cglibProxy = new CglibProxy(customer);
        final CustomerAbstract cglibProxyInstance = (CustomerAbstract) cglibProxy.getProxyInstance();
        cglibProxyInstance.exchange();
    }
}
