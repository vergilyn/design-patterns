package com.vergilyn.examples.pattern.state.player;

/**
 * @author vergilyn
 * @since 2021-11-05
 */
public interface AbstractPlayer {
	void play();

	void pause();

	void stop();

	void request(int action);

	void setState(AbstractPlayerState state);
	AbstractPlayerState getState();
}
