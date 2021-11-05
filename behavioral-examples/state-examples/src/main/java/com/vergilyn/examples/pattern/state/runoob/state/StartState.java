package com.vergilyn.examples.pattern.state.runoob.state;

import com.vergilyn.examples.pattern.state.runoob.AbstractState;
import com.vergilyn.examples.pattern.state.runoob.Context;

public class StartState implements AbstractState {

	@Override
	public void doAction(Context context) {
		System.out.println("Player is in start state");

		// 设置状态
		context.setState(this);
	}

	@Override
	public String toString(){
		return "Start AbstractState";
	}
}
