package com.psocratic.workchop;

public class WorkchopException extends Exception {
    public WorkchopException(String message) {
        super(message);
    }

    public WorkchopException(String message, Throwable t) {
        super(message, t);
    }
}
