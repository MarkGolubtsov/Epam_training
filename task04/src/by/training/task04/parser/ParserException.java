package by.training.task04.parser;

public class ParserException extends Exception {
    public ParserException(String message, Exception cause) {
        super(message, cause);
    }

    public ParserException(String message) {
        super(message);
    }

    public ParserException() {
    }
}
