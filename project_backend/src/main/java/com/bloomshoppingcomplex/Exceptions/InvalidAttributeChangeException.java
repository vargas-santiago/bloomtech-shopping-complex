package com.bloomshoppingcomplex.Exceptions;

public class InvalidAttributeChangeException extends RuntimeException {
    private static final long serialVersionUID = 1496337207699565756L;

    public InvalidAttributeChangeException() { super(); }

    public InvalidAttributeChangeException(String message) { super(message); }

    public InvalidAttributeChangeException(Throwable cause) { super(cause); }

    public InvalidAttributeChangeException(String message, Throwable cause) { super(message, cause); }
}
