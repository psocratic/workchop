package com.psocratic.workchop.line;

final class ConfigurationLine<I, R> implements Line<I, R> {
    private final Line<I, ? extends R> outputSpec;
    private final Line<R, ?> configurationSpec;

    ConfigurationLine(Line<I, ? extends R> outputSpec, Line<R, ?> configuratingSpec) {
        this.outputSpec = outputSpec;
        this.configurationSpec = configuratingSpec;
    }

    @Override
    public LineResult<R> execute(I input) {
        LineResult<? extends R> result = outputSpec.execute(input);

        if(!result.succeeded())
            return new LineResultImpl<>(result.getError());

        R value = result.getValue();

        LineResult<?> configuration = configurationSpec.execute(value);

        if(!configuration.succeeded())
            return new LineResultImpl<>(configuration.getError());

        return new LineResultImpl<>(result.getValue());
    }
}
