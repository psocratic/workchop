package com.psocratic.workchop.step;

import com.psocratic.workchop.WorkchopException;

public class StepInstantiationException extends WorkchopException {
    StepInstantiationException(String message, Throwable t) {
        super(message, t);
    }

    StepInstantiationException(String s) {
        super(s);
    }
}
