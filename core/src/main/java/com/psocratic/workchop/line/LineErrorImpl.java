package com.psocratic.workchop.line;

import com.psocratic.workchop.step.StepError;

import java.util.List;

final class LineErrorImpl implements LineError {
    private final List<StepError<?, ?>> stageErrors;

    LineErrorImpl(final List<StepError<?, ?>> stageErrors) {
        this.stageErrors = stageErrors;
    }

    public List<StepError<?, ?>> getStepErrors() {
        return stageErrors;
    }
}
