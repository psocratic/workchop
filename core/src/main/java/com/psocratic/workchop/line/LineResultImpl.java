package com.psocratic.workchop.line;

final class LineResultImpl<R> implements LineResult<R> {
    private final LineError error;
    private final R value;

    LineResultImpl(final R value) {
        this(value, null);
    }

    LineResultImpl(final LineError error) {
        this(null, error);
    }

    private LineResultImpl(final R value, final LineError error) {
        this.value = value;
        this.error = error;
    }

    @Override
    public LineError getError() {
        return error;
    }

    @Override
    public R getValue() {
        return value;
    }

    @Override
    public boolean succeeded() {
        return error == null;
    }
}
