package org.example;

import java.util.Random;

public class Basketball implements Playable, Scorable {
    private static final Random RANDOMIZER = new Random();

    private String team1;
    private String team2;
    private int duration;
    private final int[] score = new int[2];

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        if (team1 == null || team1.trim().isEmpty()) {
            throw new IllegalArgumentException("Название первой команды не может быть пустым");
        }
        this.team1 = team1.trim();
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        if (team2 == null || team2.trim().isEmpty()) {
            throw new IllegalArgumentException("Название второй команды не может быть пустым");
        }
        this.team2 = team2.trim();
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration < 0) {
            throw new IllegalArgumentException("Продолжительность не может быть отрицательной");
        }
        this.duration = duration;
    }

    public int[] getScore() {
        return score;
    }

    public Basketball(String team1, String team2, int duration) {
        setTeam1(team1);
        setTeam2(team2);
        setDuration(duration);
    }

    public void play() {
        var sc = getScore();
        var dur = getDuration();
        do {
            playMach(sc);
            dur -= RANDOMIZER.nextInt(1, 9);
        } while(dur > 0);
        if(sc[0] == sc[1])
            playMach(sc);
    }

    private void playMach(int[] sc) {
        if (RANDOMIZER.nextBoolean())
            sc[0]++;
        else
            sc[1]++;
    }

    public void score() {
        System.out.printf("%s - %d : %d - %s\n" +
                "Матч длился: %d минут\n\n", getTeam1(), getScore()[0], getScore()[1], getTeam2(), getDuration());
    }
}
