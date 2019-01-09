package com.psocratic.workchop.line;

import com.psocratic.workchop.step.Step;
import com.psocratic.workchop.step.StepError;
import com.psocratic.workchop.step.StepExecutionException;
import com.psocratic.workchop.step.Steps;

import java.util.LinkedList;
import java.util.List;

final class StepLine<I, R> implements Line<I, R> {
    private final Step<I, R> step;

    StepLine(final Step<I, R> step) {
        this.step = step;
    }

    @Override
    public LineResult<R> execute(final I input) {
        final List<StepError<?, ?>> stepErrors = new LinkedList<>();

        try {
            R result = step.execute(input);
            return new LineResultImpl<>(result);
        } catch(final StepExecutionException e) {
            stepErrors.add(Steps.createError(step, e));
            return new LineResultImpl<>(new LineErrorImpl(stepErrors));
        }
    }
}
