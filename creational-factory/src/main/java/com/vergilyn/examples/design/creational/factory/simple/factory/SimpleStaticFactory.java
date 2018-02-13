package com.vergilyn.examples.design.creational.factory.simple.factory;

import com.vergilyn.examples.design.creational.factory.simple.product.Product_A;
import com.vergilyn.examples.design.creational.factory.simple.product.Product_B;
import com.vergilyn.examples.design.creational.factory.simple.product.Product_C;
import com.vergilyn.examples.design.creational.factory.simple.product.Product_D;

/**
 * 工厂类
 * @author VergiLyn
 * 2017年5月19日
 */
public class SimpleStaticFactory {
	
	public final static Product createProduct(ProductEnum type){
		Product product = null;
		switch (type) {
			case A :
				product = new Product_A();
				break;
			case B :
				product = new Product_B();
				break;
			case C :
				product = new Product_C();
				break;
			case D :
				product = new Product_D();
				break;
			default:
				break;
		}
		return product;
	}
	
	public static enum ProductEnum{
		A,B,C,D;
	}
}
