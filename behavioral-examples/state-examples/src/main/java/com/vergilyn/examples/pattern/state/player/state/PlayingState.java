package com.vergilyn.examples.pattern.state.player.state;

import com.vergilyn.examples.pattern.state.player.AbstractPlayer;
import com.vergilyn.examples.pattern.state.player.AbstractPlayerState;

public class PlayingState extends AbstractPlayerState {

	public PlayingState(AbstractPlayer player) {
		super(player);
	}

	@Override
	public void handle(int action) {
		AbstractPlayerState sourceState = player.getState();

		// FIXME 2021-11-05, 当新增`状态`，哪些`已有状态`需要对`新状态`作出反应，则可能需要此代码逻辑（违背 Open-Closed Principle）
		switch (action) {
			case PLAY_OR_PAUSE:
				player.pause();
				// 目标状态
				player.setState(new PausedState(player));
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
