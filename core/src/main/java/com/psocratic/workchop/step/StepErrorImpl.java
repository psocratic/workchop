package com.psocratic.workchop.step;

final class StepErrorImpl<I, R> implements StepError<I, R> {
    private final StepExecutionException cause;
    private final Step<I, R> step;

    StepErrorImpl(final Step<I, R> step, final StepExecutionException cause) {
        this.cause = cause;
        this.step = step;
    }

    public StepExecutionException getCause() {
        return cause;
    }

    public Step<I, R> getStep() {
        return step;
    }
}
