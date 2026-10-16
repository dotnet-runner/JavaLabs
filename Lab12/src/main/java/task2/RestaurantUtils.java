package task2;

import java.util.Comparator;
import java.util.List;

public final class RestaurantUtils {
    private RestaurantUtils() {}

    public static void deleteBadRestaurants(List<Restaurant> restaurants) {
        restaurants.removeIf(r -> r.getAverageScore() <= 3.0);
    }

    public static void gradeUpGoodRestaurants(List<Restaurant> restaurants) {
        restaurants.stream()
                .filter(r -> r.getAverageScore() >= 4)
                .forEach(r -> {
                    try {
                        r.setStars(r.getStars() + 1);
                    }
                    catch (Exception ignored) {}
                });
    }

    public static void printRestaurants(List<Restaurant> restaurants) {
        restaurants.forEach(System.out::println);
    }

    public static void sortRestaurants(List<Restaurant> restaurants) {
        var doubleComparator = Comparator.comparingDouble(Restaurant::getAverageScore)
                .reversed()
                .thenComparing(Restaurant::getName);
        restaurants.sort(doubleComparator);
    }
}
