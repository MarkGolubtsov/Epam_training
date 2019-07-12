package exception;

public class FitalException extends Exception {
    public FitalException() {}

    public FitalException(String message, Throwable cause) {
        super(message, cause);
    }

    public FitalException(String message) {
        super(message);
    }

    public FitalException(Throwable cause) {
        super(cause);
    }
}
