package org;

import java.util.Arrays;
import java.util.Comparator;

public class Application {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    public static void task1() {
        var circles = new Circle[] {
                new Circle(12.12),
                new Circle(31.772),
                new Circle(512.731),
                new Circle(94.12)
        };

        for(int i = 0; i < circles.length; i++) {
            circles[i].printParams();
        }
    }

    public static void task2() {
        var games = new Game[] {
                new Game("The saw", "Horror", 0),
                new Game("Squid Game", "Survival thriller", 31500000),
                new Game("Poker", "Classic card game", 20563324),
                new Game("Fortnite", "Battle royal", 3784225),
                new Game("Hide in seek", "Action game", 1000000)
        };

        var maxGame = Arrays.stream(games).max(Comparator.comparingDouble(x->x.getPrice())).orElseThrow();
        var minGame = Arrays.stream(games).min(Comparator.comparingDouble(x->x.getPrice())).orElseThrow();
        System.out.printf("Game with maximum winer cash cup: %s\n" +
                          "Game with minimum winner cash cup: %s\n", maxGame.getTitle(), minGame.getTitle());
    }

    public static void task3() {
        for (DayOfWeek day : DayOfWeek.values()) {
            System.out.printf("Day of week: %9s is %s day\n", day, DayOfWeek.isWeekend(day) ? "weekend" : "working" );
        }
    }
}
