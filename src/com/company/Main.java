package com.company;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();

        Thread firstTeam = new Thread(new Team("Java", game));
        Thread secondTeam = new Thread(new Team("C#", game));

        firstTeam.start();
        secondTeam.start();

    }
}
