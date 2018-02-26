package com.rsm;

public class Start {

    public static void main(String[] args) throws InterruptedException {

        Scenario scenario = new Scenario();
        Entrace entrace = new Entrace();
        GamePlay gameplay = new GamePlay();

        scenario.start();

        while (gameplay.isPlay()) {
            entrace.waitEnter(scenario);
            gameplay.round(entrace, scenario);
            gameplay.playAgain(scenario, entrace);
        }

        System.exit(0);
    }
}
