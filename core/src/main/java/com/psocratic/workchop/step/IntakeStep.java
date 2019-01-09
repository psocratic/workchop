package com.psocratic.workchop.step;

final class IntakeStep<T> implements Step<T, T> {
    @Override
    public T execute(T input) throws StepExecutionException {
        return input;
    }
}
