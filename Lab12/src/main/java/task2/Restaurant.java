package task2;

import java.util.List;
import java.util.stream.Collectors;

public class Restaurant {
    private int id;
    private static int resId;
    private String name;
    private List<Cuisine> cuisine;
    private int stars;
    private List<Integer> reviews;

    public Restaurant(String name, List<Cuisine> cuisine, int stars, List<Integer> reviews) {
        resId++;
        id = resId;
        setName(name);
        setCuisine(cuisine);
        setStars(stars);
        setReviews(reviews);
    }

    public int getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {
        if(name.isBlank())
            throw new IllegalArgumentException("Argument 'name' can't be null or whitespace");

        this.name = name;
    }

    public List<Cuisine> getCuisine() {return cuisine;}
    public void setCuisine(List<Cuisine> cuisine) {
        if(cuisine.isEmpty())
            throw new IllegalArgumentException("Argument 'cuisine' can't be null or empty");

        this.cuisine = cuisine;
    }

    public int getStars() {return stars;}
    public void setStars(int stars) {
        if(stars < 0 || stars > 5)
            throw new IllegalArgumentException("Argument 'stars' should be in range 1-5");

        this.stars = stars;
    }

    public List<Integer> getReviews() {return reviews;}
    public void setReviews(List<Integer> reviews) {
        if(reviews.isEmpty())
            throw new IllegalArgumentException("Argument 'reviews' can't be null or empty");

        this.reviews = reviews;
    }

    public double getAverageScore() {
        var average = getReviews().stream().mapToInt(Integer::intValue).average().orElse(0.0);
        return Math.round(average  * 100) / 100.0;
    }

    public String toString() {
        var cuisine = getCuisine().stream().map(Enum::name).collect(Collectors.joining(", "));
        return "Id: " + getId() + "; Name: " + getName() + "; Cuisines: " + cuisine + "; Stars: " + getStars() + "; Average rating: " + getAverageScore();
    }
}
