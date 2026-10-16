package org.example;

public class Sportsman {
    private String name;
    private String team;
    private int number;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.isBlank())
            return;
        this.name = name;
    }

    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        if(team.isBlank())
            return;
        this.team = team;
    }

    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        if(0 > number)
            return;
        this.number = number;
    }

    public Sportsman(String name, String team, int number) {
        setName(name);
        setTeam(team);
        setNumber(number);
    }

    public String getPosition() {return "";}
    public void displayInfo() {
        System.out.printf("Имя: %s, команда: %s, номер: %d%s\n", getName(), getTeam(), getNumber(), getPosition().isBlank() ? "" : ", позиция: " + getPosition());
    }
}
