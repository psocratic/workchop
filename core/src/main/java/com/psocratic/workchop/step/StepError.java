package com.psocratic.workchop.step;

/**
 * Stores information about an error that
 * occurred while executing a {@link Step}.
 *
 * @param <I> The input type of the failed {@link Step}.
 * @param <R> The output type of the the failed {@link Step}.
 */
public interface StepError<I, R> {
    /**
     * @return The exception that was thrown when by the failed {@link Step}.
     */
    StepExecutionException getCause();

    /**
     * @return The failed {@link Step}.
     */
    Step<I, R> getStep();
}
