package com.vergilyn.examples.design.structural.proxy.basic.kinds;

import com.vergilyn.examples.design.structural.proxy.basic.common.Customer;
import com.vergilyn.examples.design.structural.proxy.basic.common.CustomerAbstract;

/**
 * 代理对象和目标对象实现相同的接口
 * @author VergiLyn
 * @blog http://www.cnblogs.com/VergiLyn/
 * @date 2017/8/8
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
