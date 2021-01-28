package com.vergilyn.examples.design.strategy.handler;

/**
 * 
 * @author vergilyn
 * @since 2021-01-28
 */
public class PromotionHandler implements AbstractHandler {

	@Override
	public String handler(String param) {
		return this.getClass().getSimpleName() + " >>>> " + param;
	}
}
