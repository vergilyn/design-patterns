package com.vergilyn.examples.pattern.state.runoob;

import com.vergilyn.examples.pattern.state.runoob.state.StartState;
import com.vergilyn.examples.pattern.state.runoob.state.StopState;

public class StateMainTest {

	public static void main(String[] args) {
		Context context = new Context();

		StartState startState = new StartState();
		startState.doAction(context);

		System.out.println(context.getState().toString());

		StopState stopState = new StopState();
		stopState.doAction(context);

		System.out.println(context.getState().toString());
	}
}
