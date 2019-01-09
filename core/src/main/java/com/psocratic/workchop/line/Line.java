package com.psocratic.workchop.line;

/**
 * Transforms an input to a result.
 *
 * {@link Line} has a single method {@link #execute} which
 * transforms values of input type {@code I}, and passes them
 * through successive steps until either one of them throws
 * an exception, or the final step is successfully executed.

 * @param <I> The input type of the line.
 * @param <R> The output type of the line.
 */
public interface Line<I, R> {
    /**
     * Transforms values of input type {@code I} into a {@link LineResult}
     * containing values of output type {@code R}.
     *
     * @param input A value to be transformed by this line.
     * @return If the last step successfully executes, then the returned
     * {@link LineResult} is initialized with a value of output
     * type {@code R} (retrievable with {@link LineResult#getValue}),
     * and {@link LineResult#succeeded} will return {@code true}.
     *
     * Otherwise, if an error occurred during the execution of the
     * pipeline, the {@link LineResult} will be initialized with
     * details of the failure (retrievable with {@link LineResult#getError}),
     * and {@link LineResult#succeeded} will return {@code false}.
     */
    LineResult<R> execute(I input);
}
