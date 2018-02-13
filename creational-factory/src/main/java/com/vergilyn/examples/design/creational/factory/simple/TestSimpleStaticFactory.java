package com.vergilyn.examples.design.creational.factory.simple;

import com.vergilyn.examples.design.creational.factory.simple.factory.Product;
import com.vergilyn.examples.design.creational.factory.simple.factory.SimpleStaticFactory;

/**
 * 测试简单工厂模式。
 * @author VergiLyn
 * 2017年5月19日
 */
public class TestSimpleStaticFactory {
	public static void main(String[] args) {
		Product a = SimpleStaticFactory.createProduct(SimpleStaticFactory.ProductEnum.A);
		System.out.println(a.getName());
		
		Product c = SimpleStaticFactory.createProduct(SimpleStaticFactory.ProductEnum.C);
		System.out.println(c.getName());
	}
}
