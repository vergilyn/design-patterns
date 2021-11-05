package com.vergilyn.examples.pattern.state.player;

import com.vergilyn.examples.pattern.state.player.state.StoppedState;

public class Player implements AbstractPlayer {
	private AbstractPlayerState state = new StoppedState(this);

	@Override
	public void play() {
		System.out.println("play video.");
	}

	@Override
	public void pause() {
		System.out.println("pause video.");
	}

	@Override
	public void stop() {
		System.out.println("stop video.");
	}

	@Override
	public void request(int action) {
		System.out.println("before action:" + state.toString());

		state.handle(action);

		System.out.println("after action:" + state.toString());
	}

	@Override
	public void setState(AbstractPlayerState state) {
		this.state = state;
	}

	@Override
	public AbstractPlayerState getState() {
		return this.state;
	}
}
