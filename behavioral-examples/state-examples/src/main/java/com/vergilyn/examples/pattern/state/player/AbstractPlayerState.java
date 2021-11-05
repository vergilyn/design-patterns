package com.vergilyn.examples.pattern.state.player;

public abstract class AbstractPlayerState {
	public final static int PLAY_OR_PAUSE = 0;
	public final static int STOP = 1;

	protected AbstractPlayer player;

	public AbstractPlayerState(AbstractPlayer player) {
		this.player = player;
	}

	public abstract void handle(int action);

	@Override
	public String toString() {
		return "current state: " + this.getClass().getSimpleName();
	}
}
