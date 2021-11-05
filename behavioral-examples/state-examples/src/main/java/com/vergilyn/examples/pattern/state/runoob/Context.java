package com.vergilyn.examples.pattern.state.runoob;

public class Context {
	private AbstractState state;

	public Context() {
		state = null;
	}

	public void setState(AbstractState state) {
		this.state = state;
	}

	public AbstractState getState() {
		return state;
	}
}
