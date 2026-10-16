package task_1;

public class Graduate extends Student {
    private String thesis;

    public Graduate(String name, String grade, String thesis) {
        super(name, grade);
        setThesis(thesis);
    }

    public String getThesis() {return thesis;}
    public void setThesis(String thesis) {
        if(thesis == null || thesis.isBlank())
            throw new IllegalArgumentException("Thesis can't be a null or whitespace");
        this.thesis = thesis;
    }

    public String toString() {
        return super.toString() + " Thesis: " + getThesis();
    }
}
