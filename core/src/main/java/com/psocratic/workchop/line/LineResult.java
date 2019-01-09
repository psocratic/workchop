package com.psocratic.workchop.line;

/**
 * Contains the result of an invocation to {@link Line#execute}.
 * @param <R> The type of the result's value
 */
public interface LineResult<R> {
    /**
     * @return A {@link LineError} containing step-processing errors, or {@code null} if
     * the execution succeeded.
     */
    LineError getError();

    /**
     * @return The value produced by the line execution. The value is {@code null} if the
     * when an execution fails.
     */
    R getValue();

    /**
     *
     * @return Returns {@code true} if the line execution succeeded; otherwise {@code false}.
     */
    boolean succeeded();
}
