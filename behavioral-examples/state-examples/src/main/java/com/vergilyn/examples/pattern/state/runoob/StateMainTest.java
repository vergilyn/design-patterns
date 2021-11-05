package com.vergilyn.examples.pattern.state.runoob;

import com.vergilyn.examples.pattern.state.runoob.state.StopState;

/**
 * start --[doAction]--> stop,
 * stop --[doAction]--> start
 */
public class StateMainTest {

	// 示例代码写的不好，但代码结构大致是这样。
	public static void main(String[] args) {
		Context context = new Context();


		final StopState stopState = new StopState();
		stopState.doAction(context);

		// FIXME 2021-11-05，这个 context 的结构感觉怪怪的，待调整（是否可以state 中有成员变量 context？）
		context.getState().doAction(context);
	}
}
