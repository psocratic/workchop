package com.psocratic.workchop.line;

final class WildcardDowncastingLine<I, R> implements Line<I, R> {
    private final Line<I, ? extends R> line;

    WildcardDowncastingLine(Line<I, ? extends R> line) {
        this.line = line;
    }

    @Override
    public LineResult<R> execute(I input) {
        LineResult<? extends R> result = line.execute(input);

        if(!result.succeeded())
            return new LineResultImpl<>(result.getError());

        return new LineResultImpl<>(result.getValue());
    }
}
