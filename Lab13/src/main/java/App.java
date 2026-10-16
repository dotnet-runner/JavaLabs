import exceptions.FilmNotFoundException;
import exceptions.InvalidFilmDataException;
import exceptions.RatingUpdateException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        var film1 = new Film("Черный телефон 2", "Скотт Дерриксон", 2025, 7.1, Genre.Horror);
        var film2 = new Film("Опенгеймер", "Кристофер Нолан", 2023, 8.1, Genre.Since);
        var film3 = new Film("Тёмный рыцарь", "Кристофер Нолан", 2008, 8.5, Genre.Action);
        var film4 = new Film("Техасская резня бензопилой", "Тоуб Хупер", 1974, 6.6, Genre.Horror);
        var film5 = new Film("Проект аве Мария", "Кристофер Миллер", 2025, 8.4, Genre.Since_fiction);
        var film6 = new Film("Лемони Сникет: 33 несчастья", "Брэд Силберлинг", 2004, 7.3, Genre.Detective);
        var film7 = new Film("Супруги Роуз", "Джей Роуч", 2025, 6.9, Genre.Comedy);

        try {
            var film8 = new Film("Jaws", "Steven Spielberg", 1875, 7.8, Genre.Horror);
        }
        catch (InvalidFilmDataException ex) {
            System.err.println(ex.getMessage());
        }

        try {
            film7.updateRating(12);
        }
        catch (RatingUpdateException ex) {
            System.err.println(ex.getMessage());
        }

        List<Film> films = Arrays.asList(film1, film2, film3, film4, film5, film6, film7);
        List<Film> newFilms2025 = new ArrayList<>();

        films.forEach( el -> {
            try{
                var res = el.getFilmByYear(2025);
                newFilms2025.add(res);
            }
            catch (FilmNotFoundException ex) {
                System.err.println(ex.getMessage());
            }
        });

        newFilms2025.forEach(System.out::println);
    }
}
