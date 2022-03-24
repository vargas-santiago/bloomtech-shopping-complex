package com.bloomshoppingcomplex.Exceptions;

public class StoreNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 8108830660088591539L;

    public StoreNotFoundException() {
        super();
    }

    public StoreNotFoundException(String message) {
        super(message);
    }

    public StoreNotFoundException(Throwable cause) {
        super(cause);
    }

    public StoreNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
