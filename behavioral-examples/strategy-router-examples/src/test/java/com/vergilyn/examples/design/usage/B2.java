package com.vergilyn.examples.design.usage;

import com.vergilyn.examples.design.basic.StrategyHandler;

/**
 * 叶子节点只实现 Handler 接口而无需继承 Router 抽象类（无需再向下委托）。
 *
 * @author vergilyn
 * @since 2021-01-27
 */
public class B2 implements StrategyHandler<String, Integer> {

	public static B2 newInstance(){
		return new B2();
	}

	@Override
	public Integer apply(String param) {
		System.out.println(this.getClass().getSimpleName() + "#apply()");

		return param.length() * 20;
	}
}
