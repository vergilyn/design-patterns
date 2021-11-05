package com.vergilyn.examples.pattern.state.player;

import java.util.Scanner;

/**
 * 3个状态：播放、暂停、停止。  后续增加 “重头播放”
 */
public class PlayerMainTest {

	// 输入 0 - 1 ...
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		AbstractPlayer player = new Player();
		int i = -1;
		while ((i = sc.nextInt()) != -1) {
			player.request(i);
		}
	}
}
