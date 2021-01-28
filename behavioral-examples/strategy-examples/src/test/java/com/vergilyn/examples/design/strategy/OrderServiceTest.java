package com.vergilyn.examples.design.strategy;

import org.testng.annotations.Test;

import static com.vergilyn.examples.design.strategy.OrderService.OrderTypeEnum.GROUP;
import static com.vergilyn.examples.design.strategy.OrderService.OrderTypeEnum.NORMAL;
import static com.vergilyn.examples.design.strategy.OrderService.OrderTypeEnum.PROMOTION;

/**
 *
 * @author vergilyn
 * @since 2021-01-28
 */
public class OrderServiceTest {

	@Test
	public void basic(){
		OrderService service = new OrderServiceImpl();

		System.out.println(service.handler(NORMAL, "1"));
		System.out.println(service.handler(GROUP, "2"));
		System.out.println(service.handler(PROMOTION, "3"));
	}
}
