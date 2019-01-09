package com.psocratic.workchop.line;

public class LineException extends Exception {
    LineException(String message) {
        super(message);
    }

    LineException(String message, Throwable t) {
        super(message, t);
    }
}
