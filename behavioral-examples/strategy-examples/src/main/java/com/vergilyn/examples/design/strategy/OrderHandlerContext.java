package com.vergilyn.examples.design.strategy;

import java.util.Map;

import com.google.common.collect.Maps;
import com.vergilyn.examples.design.strategy.OrderService.OrderTypeEnum;
import com.vergilyn.examples.design.strategy.handler.AbstractHandler;
import com.vergilyn.examples.design.strategy.handler.GroupHandler;
import com.vergilyn.examples.design.strategy.handler.NormalHandler;
import com.vergilyn.examples.design.strategy.handler.PromotionHandler;

import static com.vergilyn.examples.design.strategy.OrderService.OrderTypeEnum.GROUP;
import static com.vergilyn.examples.design.strategy.OrderService.OrderTypeEnum.NORMAL;
import static com.vergilyn.examples.design.strategy.OrderService.OrderTypeEnum.PROMOTION;

/**
 *
 * @author vergilyn
 * @since 2021-01-28
 */
public class OrderHandlerContext {

	private static OrderHandlerContext instance = new OrderHandlerContext();

	private final Map<OrderTypeEnum, AbstractHandler> map = Maps.newConcurrentMap();

	private OrderHandlerContext(){
		// FIXME 违背OCP，当增加handler时需要修改此代码（以及增加 Enum），可以通过reflect、custom-annotation等机制
		map.put(NORMAL, new NormalHandler());
		map.put(GROUP, new GroupHandler());
		map.put(PROMOTION, new PromotionHandler());

	}

	public static OrderHandlerContext getInstance(){
		return instance;
	}

	/**
	 * 避免违背OCP，handler实现类主动注册。
	 */
	public AbstractHandler registryHandler(OrderTypeEnum type, AbstractHandler handler){
		return instance.map.putIfAbsent(type, handler);
	}

	public AbstractHandler getHandler(OrderTypeEnum type){
		return instance.map.get(type);
	}
}
