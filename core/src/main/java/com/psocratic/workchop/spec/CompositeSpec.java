package com.psocratic.workchop.spec;

/**
 * Specifies a composition of two-or-more {@link Spec} elements, arranged
 * according to a {@link CompositionMode}.
 *
 * @param <I> The input type of the {@link Spec}
 * @param <R> The output type of the {@link Spec}
 */
public interface CompositeSpec<I, R> extends Spec<I, R> {
    /**
     * Used to describe the arrangement of {@link Spec} elements in a
     * {@link CompositeSpec}.
     */
    enum CompositionMode {
        PARALLEL,
        SERIES
    }

    /**
     * @return A {@link CompositionMode} specifying the arrangement of
     * the composited {@link Spec} elements.
     */
    default CompositionMode getCompositionMode() {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    default SpecType getSpecType() {
        return SpecType.COMPOSITE;
    }

    @Override
    default CompositeSpec<I, R> toComposite() {
        return this;
    }

    /**
     * @return When the composition mode is {@link CompositeSpec.CompositionMode#PARALLEL},
     * refines the type to a {@link ParallelSpec}. Otherwise, the behavior is
     * undefined.
     */
    default ParallelSpec<I, ? extends R> toParallel() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @return When the composition mode is {@link CompositeSpec.CompositionMode#SERIES},
     * refines the type to a {@link SeriesSpec}. Otherwise, the behavior is
     * undefined.
     */
    default SeriesSpec<I, ?, R> toSeries() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
