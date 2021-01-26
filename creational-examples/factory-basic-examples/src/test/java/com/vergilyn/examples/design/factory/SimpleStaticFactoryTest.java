package com.vergilyn.examples.design.factory;

import com.vergilyn.examples.design.factory.factory.Product;
import com.vergilyn.examples.design.factory.factory.SimpleStaticFactory;

import org.junit.jupiter.api.Test;

/**
 * 测试简单工厂模式。
 *
 * @author vergilyn
 * @date 2021-01-26
 */
public class SimpleStaticFactoryTest {

	@Test
	public void test() {
		Product a = SimpleStaticFactory.createProduct(SimpleStaticFactory.ProductEnum.A);
		System.out.println(a.getName());
		
		Product c = SimpleStaticFactory.createProduct(SimpleStaticFactory.ProductEnum.C);
		System.out.println(c.getName());
	}
}
