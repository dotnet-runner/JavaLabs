package org.example;

public class App {
    public static void main(String[] args) {
        var sportsman = new Sportsman("Фомельев Никита Андреевич", "Спартак", 17);
        var goalkeeper = new Goalkeeper("Лев Яшин Борисович", "Союз", 15, 39);
        var forward = new Forward("Ульянов Владимир Ильич", "СССР", 53, 24);

        sportsman.displayInfo();
        goalkeeper.displayInfo();
        forward.displayInfo();
        goalkeeper.makeSave();
        forward.scoreGoal();
    }
}
