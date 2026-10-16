package exceptions;

public class InvalidFilmDataException extends RuntimeException {
    public InvalidFilmDataException() {super("Некоректный год фильма, год должен быть 1900-2025");}
    public InvalidFilmDataException(String message) {super(message);}
}
