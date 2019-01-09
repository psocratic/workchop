package com.psocratic.workchop.line;

import com.psocratic.workchop.step.StepError;

import java.util.Collection;

/**
 * Contains zero-or-more step processing errors through the
 * {@link #getStepErrors()} method.
 */
public interface LineError {
    /**
     * @return A collection of zero-or-more step processing errors.
     */
    Collection<StepError<?, ?>> getStepErrors();
}
