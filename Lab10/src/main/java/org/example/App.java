package org.example;

public class App {
    public static void main(String[] args) {
        var football1 = new Football("Спартак", "Динамо", 120);
        var football2 = new Football("Барселона", "Риал Мадрид", 210);

        football1.play();
        football1.score();

        football2.play();
        football2.score();

        var basketball1 = new Basketball("Бананы", "Арбуз", 70);
        var basketball2 = new Basketball("3Б", "11В", 120);
        var basketball3 = new Basketball("Чикаго Буллз", "Лос-Анджелес Лейкерс", 48);

        basketball1.play();
        basketball1.score();

        basketball2.play();
        basketball2.score();

        basketball3.play();
        basketball3.score();
    }
}
