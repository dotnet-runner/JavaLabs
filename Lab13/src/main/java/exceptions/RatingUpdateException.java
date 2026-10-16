package exceptions;

public class RatingUpdateException extends RuntimeException {
    public RatingUpdateException() {super("Неудалось обновить рейтинг фильма, рейтинг должен быть 0-10");};
    public RatingUpdateException(String message) {
        super(message);
    }
}
