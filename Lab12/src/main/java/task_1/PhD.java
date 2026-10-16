package task_1;

import java.util.Arrays;
import java.util.List;

public class PhD extends Student {
    private List<String> publications;

    public PhD(String name, String grade, List<String> publications) {
        super(name, grade);
        setPublications(publications);
    }

    public PhD(String name, String grade, String... publications) {
        this(name, grade, Arrays.asList(publications));
    }

    public List<String> getPublications() {return publications;}
    public void setPublications(List<String> publications) {
        if(publications.isEmpty())
            throw new IllegalArgumentException("Argument 'publications' can't be null or empty");
        this.publications = publications;
    }

    public String toString() {
        return super.toString() + " Publications: " + String.join(", ", publications);
    }
}
