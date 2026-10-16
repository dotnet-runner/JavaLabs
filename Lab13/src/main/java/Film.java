import exceptions.InvalidFilmDataException;
import exceptions.RatingUpdateException;
import exceptions.FilmNotFoundException;

public class Film {
    private String title;
    private String director;
    private int year;
    private double rating;
    private Genre genre;

    public String getTitle() {return title;}
    public void setTitle(String title) {
        if(title.isBlank())
            throw new IllegalArgumentException();

        this.title = title;
    }

    public String getDirector() {return director;}
    public void setDirector(String director) {
        if(director.isBlank())
            throw new IllegalArgumentException();

        this.director = director;
    }

    public int getYear() {return year;}
    public void setYear(int year) {
        if(year < 1900 || year > 2025)
            throw new InvalidFilmDataException();

        this.year = year;
    }

    public double getRating() {return rating;}
    private void setRating(double rating) {
        if( 0 > rating || rating > 10)
            throw new IllegalArgumentException("Ошибка установки рейтинга, рейтинг должен быть 0-10");

        this.rating = rating;
    }

    public Genre getGenre() {return genre;}
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Film(String title, String director, int year, double rating, Genre genre) {
        setTitle(title);
        setDirector(director);
        setYear(year);
        setRating(rating);
        setGenre(genre);
    }

    public void updateRating(double newRating) {
        try {
            setRating(newRating);
        }
        catch(IllegalArgumentException ex) {
            throw new RatingUpdateException();
        }
    }

    public Film getFilmByYear(int year) {
        if(getYear() != year)
            throw new FilmNotFoundException();

        return this;
    }

    public String toString() {
        return "Фильм: " + getTitle() +
                "; Режисер: " + getDirector() +
                "; Снят был в " + getYear() +
                "г. Рейтинг: " + getRating() +
                "; Жанр: " + getGenre().name();
    }
}
