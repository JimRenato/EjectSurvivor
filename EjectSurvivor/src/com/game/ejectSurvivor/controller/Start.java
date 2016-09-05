package com.game.ejectSurvivor.controller;

import com.game.ejectSurvivor.views.Scenario;

public class Start {

	public static void main(String[] args) throws InterruptedException {

		Scenario scenario = new Scenario();
		Entrace entrace = new Entrace();
		GamePlay gameplay = new GamePlay();

		scenario.start();

		while (gameplay.isPlay()) {
			entrace.waitEnter(scenario);
			gameplay.round(entrace, scenario);
			gameplay.playAgain(null, scenario, entrace);
		}
		
		System.exit(0);
	}
}
