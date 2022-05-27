package com.company;

import java.util.Random;

public class Team implements Runnable {
    private final String name;
    private final Game game;
    public Team(String name, Game game) {
        this.name = name;
        this.game = game;
    }
    @Override
    public void run() {
        Random random = new Random();
        game.setBallCount(random.nextInt(16));
        System.out.println("Команда: " + this.name +
                " количество голов:" + this.game.getBallCount());
        game.setYellowCards(random.nextInt(16));
        System.out.println("Команда: " + this.name +
                " количество желтых карточек:" + this.game.getYellowCards());
        game.setOffsideCount(random.nextInt(16));
        System.out.println("Команда: " + this.name +
                " количество офсайд:" + this.game.getOffsideCount());
    }
}

