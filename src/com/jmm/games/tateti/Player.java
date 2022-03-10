package com.jmm.games.tateti;

public class Player {
    private String name;
    private int score;
    private char choose;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public char getChoose() {
        return choose;
    }

    public void setChoose(char choose) {
        this.choose = choose;
    }
}
