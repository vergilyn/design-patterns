package com.vergilyn.examples.pattern.state.spring;

public enum StateEnum {
	/** 待支付 */
	UNPAID,

	/** 待收货 */
	WAITING_FOR_RECEIVE,

	/** 结束 */
	DONE;
}
