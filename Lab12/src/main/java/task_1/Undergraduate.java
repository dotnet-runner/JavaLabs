package task_1;

import java.time.LocalDate;

public class Undergraduate extends Student {
    private int year;

    public Undergraduate(String name, String grade, int year) {
        super(name, grade);
        setYear(year);
    }

    public int getYear() {return year;}
    public void setYear(int year) {
        if(year > LocalDate.now().getYear())
            throw new IllegalArgumentException("Argument 'year' can't be more then nowadays year");
        this.year = year;
    }

    public String toString() {
        return super.toString() + " Year: " + getYear();
    }
}
