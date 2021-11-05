package com.vergilyn.examples.pattern.state.player.state;

import com.vergilyn.examples.pattern.state.player.AbstractPlayer;
import com.vergilyn.examples.pattern.state.player.AbstractPlayerState;

public class PausedState extends AbstractPlayerState {

	public PausedState(AbstractPlayer player) {
		super(player);
	}

	@Override
	public void handle(int action) {
		switch (action) {
			case PLAY_OR_PAUSE:
				player.play();
				player.setState(new PlayingState(player));
				break;
			case STOP:
				player.stop();
				player.setState(new StoppedState(player));
				break;
			default:
				throw new IllegalArgumentException(
						"ERROR ACTION:" + action + ",current state:" + this.getClass().getSimpleName());
		}
	}
}
