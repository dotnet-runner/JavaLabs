package org.example;

public class Forward extends Sportsman {
    private int goals;

    public int getGoals() {
        return goals;
    }
    public void setGoals(int goals) {
        if(0 > goals)
            return;
        this.goals = goals;
    }

    public Forward(String name, String team, int number, int goals) {
        super(name, team, number);
        setGoals(goals);
    }

    public String getPosition() {
        return "Нападающий";
    }

    public void scoreGoal() {
        System.out.printf("Нападающий забивает мячь и его счет: %d\n", ++goals);
    }
}
