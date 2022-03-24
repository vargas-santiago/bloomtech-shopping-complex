package com.bloomshoppingcomplex.Exceptions;

public class ItemNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 19208649982956612L;

    public ItemNotFoundException() {
        super();
    }

    public ItemNotFoundException(String message) {
        super(message);
    }

    public ItemNotFoundException(Throwable cause) {
        super(cause);
    }

    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
