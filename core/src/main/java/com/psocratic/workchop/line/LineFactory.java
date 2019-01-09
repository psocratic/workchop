package com.psocratic.workchop.line;

import com.psocratic.workchop.spec.Spec;

/**
 * Creates a {@link Line} from a {@link Spec} through the
 * {@link #create} method.
 */
public interface LineFactory {
    /**
     * Creates a {@link Line} from the provided {@link Spec}.
     *
     * @param spec The specification for the resulting {@link Line}
     * @param <I> The input type of the provided {@link Spec} and resulting {@link Line}
     * @param <R> The output type of the provided {@link Spec} and resulting {@link Line}
     * @return A {@link Line} transforming inputs of type {@code I} to results of type {@code R}
     * @throws LineFactoryException if the provided spec is invalid or of an unsupported type
     */
    <I, R> Line<I, R> create(Spec<I, R> spec) throws LineFactoryException;
}
