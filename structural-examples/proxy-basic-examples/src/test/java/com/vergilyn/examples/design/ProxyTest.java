package com.vergilyn.examples.design;

import com.vergilyn.examples.design.proxy.common.Customer;
import com.vergilyn.examples.design.proxy.common.CustomerAbstract;
import com.vergilyn.examples.design.proxy.kinds.CglibProxy;
import com.vergilyn.examples.design.proxy.kinds.JdkProxy;
import com.vergilyn.examples.design.proxy.kinds.StaticProxy;

import org.junit.jupiter.api.Test;

/**
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class ProxyTest {

    @Test
    public void test(){
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
