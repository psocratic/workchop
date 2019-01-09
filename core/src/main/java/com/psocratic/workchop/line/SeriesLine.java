package com.psocratic.workchop.line;

import com.psocratic.workchop.step.StepError;

import java.util.LinkedList;
import java.util.List;

final class SeriesLine<I, O, R> implements Line<I, R> {
    private final Line<I, O> headLine;
    private final Line<O, R> tailLine;

    SeriesLine(Line<I, O> headLine, Line<O, R> tailLine) {
        this.headLine = headLine;
        this.tailLine = tailLine;
    }

    @Override
    public LineResult<R> execute(I input) {
        final List<StepError<?, ?>> stageErrors = new LinkedList<>();
        final LineResult<O> headResult = headLine.execute(input);

        if (headResult.succeeded()) {
            LineResult<R> tailResult = tailLine.execute(headResult.getValue());

            if (!tailResult.succeeded()) {
                stageErrors.addAll(tailResult.getError().getStepErrors());
            }

            R value = tailResult.getValue();
            return new LineResultImpl<>(value);
        } else {
            stageErrors.addAll(headResult.getError().getStepErrors());
        }

        return new LineResultImpl<>(new LineErrorImpl(stageErrors));
    }
}
