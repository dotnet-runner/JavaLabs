import task2.Cuisine;
import task2.Restaurant;
import task2.RestaurantUtils;
import task_1.Graduate;
import task_1.PhD;
import task_1.Student;
import task_1.Undergraduate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        try {
            Map<String, Student> students = Map.of(
                    "Slim Shady", new Undergraduate("Slim Shady", "Artist", 2007),
                    "Monkey Bill", new Undergraduate("Monkey Bill", "Cook", 2025),
                    "Winston", new Undergraduate("Winston", "Sinner", 1984),
                    "William", new Graduate("William", "Theoretic", "When you eat the burger, when you sit at home and drink coffee, are ypu think you eat yourself?"),
                    "Nick", new Graduate("Nick", "Marketing and statistics", "My 100 ideas for business"),
                    "Bob", new Graduate("Bob", "Main Architect", "What is the rock?"),
                    "Alice", new PhD("Alice", "Art master", "Art is peace", "Six seven or slop machine", "Masha and Bear"),
                    "Mike", new PhD("Mike", "Senior Programmist", "C# for beginners", "Harry Potter and C#")
            );
            students.forEach( (key, el) -> {
                System.out.printf("%-12s %s\n", key, el);
            });
        }
        catch(Exception ex) {
            System.err.println(ex.getMessage());
        }

        List<Restaurant> restaurants = new ArrayList<>(List.of(
                new Restaurant(
                        "Presto Pasta",
                        List.of(Cuisine.ITALIAN),
                        4,
                        List.of(4, 3, 5, 4)
                ),
                new Restaurant(
                        "Le Bistro",
                        List.of(Cuisine.FRENCH),
                        5,
                        List.of(5, 4, 5, 5, 4)
                ),
                new Restaurant(
                        "Fusion East",
                        List.of(Cuisine.CHINESE, Cuisine.JAPANESE),
                        4,
                        List.of(1, 3, 2, 3)
                )
        ));

        RestaurantUtils.printRestaurants(restaurants);
        RestaurantUtils.deleteBadRestaurants(restaurants);
        System.out.println("After delete:");
        RestaurantUtils.printRestaurants(restaurants);
        RestaurantUtils.gradeUpGoodRestaurants(restaurants);
        System.out.println("After grade up:");
        RestaurantUtils.printRestaurants(restaurants);
        RestaurantUtils.sortRestaurants(restaurants);
        System.out.println("After sort:");
        RestaurantUtils.printRestaurants(restaurants);
    }
}