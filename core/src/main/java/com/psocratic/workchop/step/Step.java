package com.psocratic.workchop.step;

import com.psocratic.workchop.line.Line;

/**
 * {@link Step} is responsible for carrying out
 * the fundamental unit of work in a {@link Line}:
 * transforming inputs to outputs.
 *
 * @param <I> The input type of the step.
 * @param <O> The output type of the step.
 */
public interface Step<I, O> {
    /**
     * Carry out a transformation.
     *
     * @param input The input to transform.
     * @return An output.
     * @throws StepExecutionException When en error occurs while transforming the input.
     */
    O execute(I input) throws StepExecutionException;
}