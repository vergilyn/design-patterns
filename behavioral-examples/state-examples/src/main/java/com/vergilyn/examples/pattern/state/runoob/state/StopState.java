package com.vergilyn.examples.pattern.state.runoob.state;

import com.vergilyn.examples.pattern.state.runoob.AbstractState;
import com.vergilyn.examples.pattern.state.runoob.Context;

public class StopState implements AbstractState {

	@Override
	public void doAction(Context context) {
		System.out.println("Player is in stop state");

		// 设置状态
		context.setState(this);
	}

	@Override
	public String toString(){
		return "Stop AbstractState";
	}
}
