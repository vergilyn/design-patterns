package com.vergilyn.examples.pattern.state.player.state;

import com.vergilyn.examples.pattern.state.player.AbstractPlayer;
import com.vergilyn.examples.pattern.state.player.AbstractPlayerState;

public class StoppedState extends AbstractPlayerState {

	public StoppedState(AbstractPlayer player) {
		super(player);
	}

	@Override
	public void handle(int action) {
		if (action == PLAY_OR_PAUSE) {
			player.play();
			player.setState(new PlayingState(player));
		}

		throw new IllegalArgumentException(
				"ERROR ACTION:" + action + ",current state:" + this.getClass().getSimpleName());
	}
}