package com.vergilyn.examples.design.strategy;

/**
 *
 * @author vergilyn
 * @since 2021-01-28
 */
public class OrderServiceImpl implements OrderService {

	private final OrderHandlerContext context;

	public OrderServiceImpl() {
		this.context = OrderHandlerContext.getInstance();
	}

	@Override
	public String handler(OrderTypeEnum type, String param) {
		return context.getHandler(type).handler(param);
	}
}
