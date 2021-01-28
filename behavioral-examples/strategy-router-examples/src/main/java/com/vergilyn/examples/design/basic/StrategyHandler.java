package com.vergilyn.examples.design.basic;

/**
 *
 * @author vergilyn
 * @since 2021-01-27
 */
public interface StrategyHandler<T, R> {

	/**
	 * apply strategy
	 *
	 * @param param
	 * @return
	 */
	R apply(T param);
}
