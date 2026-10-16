package task_1;

public class Student {
    private String name;
    private int studentId;
    private static int id;
    private String grade;

    public Student(String name, String grade) {
        id++;
        studentId = id;
        setName(name);
        setGrade(grade);
    }

    public String getName() {return name;}
    public void setName(String name) {
        if(name.isBlank())
            throw new IllegalArgumentException("Argument 'name' can't be null or whitespace");
        this.name = name;
    }

    public int getId() {return studentId;}

    public String getGrade() {return grade;}
    public void setGrade(String grade) {
        if(grade.isBlank())
            throw new IllegalArgumentException("Argument 'grade' can't be null or whitespace");
        this.grade = grade;
    }

    public String toString() {
        return "Id: " + getId() + "; Name: " + getName() + "; Grade: " + getGrade() + ";";
    }
}