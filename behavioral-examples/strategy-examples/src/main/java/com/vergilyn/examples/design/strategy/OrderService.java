package com.vergilyn.examples.design.strategy;

/**
 *
 * @author vergilyn
 * @since 2021-01-28
 */
public interface OrderService {

	String handler(OrderTypeEnum type, String param);

	enum OrderTypeEnum {
		/**
		 * 普通
		 */
		NORMAL,

		/**
		 * 团购
		 */
		GROUP,

		/**
		 * 促销
		 */
		PROMOTION;
	}
}
