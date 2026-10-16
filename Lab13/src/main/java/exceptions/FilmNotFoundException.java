package exceptions;

public class FilmNotFoundException extends RuntimeException {
    public FilmNotFoundException() {super("Фильм не был найден");}
    public FilmNotFoundException(String message) {
        super(message);
    }
}
