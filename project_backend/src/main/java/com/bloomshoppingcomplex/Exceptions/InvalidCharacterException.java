package com.bloomshoppingcomplex.Exceptions;

public class InvalidCharacterException extends RuntimeException {
    private static final long serialVersionUID = -6415633257982720378L;

    public InvalidCharacterException() {
        super();
    }

    public InvalidCharacterException(String message) {
        super(message);
    }

    public InvalidCharacterException(Throwable cause) {
        super(cause);
    }

    public InvalidCharacterException(String message, Throwable cause) {
        super(message, cause);
    }
}
