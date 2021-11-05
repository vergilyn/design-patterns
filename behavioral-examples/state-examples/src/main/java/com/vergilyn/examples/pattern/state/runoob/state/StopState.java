package com.vergilyn.examples.pattern.state.runoob.state;

import com.vergilyn.examples.pattern.state.runoob.AbstractState;
import com.vergilyn.examples.pattern.state.runoob.Context;

public class StopState implements AbstractState {

	@Override
	public void doAction(Context context) {
		final StopState target = new StopState();

		System.out.printf("current-state[%s]  >>>> do action >>>> target-state[%s].\n",
		                  context.getState(), target);

		// 设置状态(或 切换状态)
		context.setState(target);
	}

	@Override
	public String toString(){
		return "stop";
	}
}
