package com.psocratic.workchop.line;

public class LineFactoryException extends LineException {
    LineFactoryException(String message) {
        super(message);
    }

    LineFactoryException(String message, Throwable t) {
        super(message, t);
    }
}
