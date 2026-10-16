package org.example;

public class Goalkeeper extends Sportsman {
    private int saves;

    public int getSaves() {
        return saves;
    }
    public void setSaves(int saves) {
        if(0 > saves)
            return;
        this.saves = saves;
    }

    public Goalkeeper(String name, String team, int number, int saves) {
        super(name, team, number);
        setSaves(saves);
    }

    public String getPosition() {
        return "Вратарь";
    }

    public void makeSave() {
        System.out.printf("Вратарь сохраняет мячь, его счет: %d\n", ++saves);
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.printf("Позиция: %s, его номер: %d\n", getPosition(), getNumber());
    }
}
