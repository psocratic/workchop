package com.psocratic.workchop.spec;

final class SeriesSpecImpl<I, O, R> implements SeriesSpec<I, O, R> {
    private final Spec<I, O> headSpec;
    private final Spec<O, R> tailSpec;

    SeriesSpecImpl(Spec<I, O> headSpec, Spec<O, R> tailSpec) {
        this.headSpec = headSpec;
        this.tailSpec = tailSpec;
    }

    @Override
    public Spec<I, O> getHeadSpec() {
        return headSpec;
    }

    @Override
    public Spec<O, R> getTailSpec() {
        return tailSpec;
    }
}
