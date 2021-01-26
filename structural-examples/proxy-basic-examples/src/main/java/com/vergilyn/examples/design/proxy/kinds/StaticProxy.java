package com.vergilyn.examples.design.proxy.kinds;

import com.vergilyn.examples.design.proxy.common.Customer;
import com.vergilyn.examples.design.proxy.common.CustomerAbstract;

/**
 * 代理对象和目标对象实现相同的接口
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class StaticProxy implements CustomerAbstract {
    private CustomerAbstract customer;

    public StaticProxy(){
        this.customer = customer;
    }

    public StaticProxy(CustomerAbstract customer){
        this.customer = customer;
    }

    @Override
    public void exchange() {
        this.customer.exchange();
        System.out.println("StaticProxy: " + Customer.DETAIL_DESC);
    }
}
