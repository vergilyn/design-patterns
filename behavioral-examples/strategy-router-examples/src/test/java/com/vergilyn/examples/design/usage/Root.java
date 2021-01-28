package com.vergilyn.examples.design.usage;

import com.vergilyn.examples.design.basic.AbstractStrategyRouter;
import com.vergilyn.examples.design.basic.StrategyHandler;
import com.vergilyn.examples.design.basic.StrategyMapper;

/**
 * 根节点只继承 Router 抽象类。
 *
 * @author vergilyn
 * @since 2021-01-27
 */
public class Root extends AbstractStrategyRouter<String, Integer> {

	protected static final StrategyHandler<String, Integer> DEFAULT_STRATEGY_HANDLER = t -> {
		System.out.println("default-handler#apply()");
		// 不再向下传递，结束责任链
		return 0;
	};

	public Root() {
		super();
	}

	@Override
	protected StrategyMapper<String, Integer> registerStrategyMapper() {
		return new StrategyMapper<String, Integer>(){

			@Override
			public StrategyHandler<String, Integer> get(String param) {
				if (param.startsWith("A")){
					return A.newInstance();
				}

				if (param.startsWith("B")){
					return B.newInstance();
				}

				return DEFAULT_STRATEGY_HANDLER;
			}
		};
	}
}
