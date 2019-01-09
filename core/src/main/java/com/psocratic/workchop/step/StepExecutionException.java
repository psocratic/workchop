package com.psocratic.workchop.step;

import com.psocratic.workchop.WorkchopException;

public class StepExecutionException extends WorkchopException {
    public StepExecutionException(String message) {
        super(message);
    }

    public StepExecutionException(String message, Throwable t) {
        super(message, t);
    }
}
