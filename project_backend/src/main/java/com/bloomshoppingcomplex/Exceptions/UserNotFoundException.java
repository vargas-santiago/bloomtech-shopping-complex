package com.bloomshoppingcomplex.Exceptions;

public class UserNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 2559293079248504516L;


    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
