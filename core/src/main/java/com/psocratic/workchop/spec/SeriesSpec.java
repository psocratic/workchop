package com.psocratic.workchop.spec;

/**
 * A {@link CompositeSpec} arranging two {@link Spec} elements in serial.
 *
 * @param <I> The input type of the head {@link Spec}.
 * @param <O> The output type of the head {@link Spec} and input type of the tail {@link Spec}.
 * @param <R> The output type of the tail {@link Spec}.
 */
public interface SeriesSpec<I, O, R> extends CompositeSpec<I, R> {
    @Override
    default CompositionMode getCompositionMode() {
        return CompositionMode.SERIES;
    }

    Spec<I, O> getHeadSpec();
    Spec<O, R> getTailSpec();

    @Override
    default SeriesSpec<I, O, R> toSeries() {
        return this;
    }
}
