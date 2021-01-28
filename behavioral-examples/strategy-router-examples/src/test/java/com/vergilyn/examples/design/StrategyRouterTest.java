package com.vergilyn.examples.design;

import com.vergilyn.examples.design.usage.A;
import com.vergilyn.examples.design.usage.B;
import com.vergilyn.examples.design.usage.Root;

import org.junit.jupiter.api.Test;

/**
 *
 * @author vergilyn
 * @since 2021-01-27
 */
public class StrategyRouterTest {

	/**
	 * VFIXME 2021-01-27 违背OCP
	 *   当需要增加`A3 / B3`时，需要修改 {@linkplain A} 或 {@linkplain B}。
	 *
	 * <p>
	 * {@linkplain Root} 的 handler 会一直向下传递，例如：
	 * <pre>
	 *   1) param="A", root -> A -> default-handler
	 *   2) param="A1", root -> A -> A1
	 * </pre>
	 */
	@Test
	public void basic(){
		Root root = new Root();

		root.applyStrategy("A");
	}
}
