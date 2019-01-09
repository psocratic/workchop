package com.psocratic.workchop.line;

import com.psocratic.workchop.util.kit.Kit2;
import com.psocratic.workchop.util.kit.Kit2Assembler;
import com.psocratic.workchop.util.kit.StrictKit2;
import com.psocratic.workchop.util.kit.StrictKits;

import static com.psocratic.workchop.util.kit.StrictKits.kit;

final class Parallel2Line<I, E1, E2, R extends Kit2<E1, E2>> implements Line<I, R> {
    private final StrictKit2<?, Line<I, ?>, Line<I, E1>, Line<I, E2>> lines;
    private final Kit2Assembler<E1, E2, R> partFactory;

    Parallel2Line(StrictKit2<?, Line<I, ?>, Line<I, E1>, Line<I, E2>> lines,
                  Kit2Assembler<E1, E2, R> partFactory) {
        this.lines = lines;
        this.partFactory = partFactory;
    }

    @Override
    public LineResult<R> execute(I input) {
        StrictKit2<?, LineResult<?>, LineResult<E1>, LineResult<E2>> results
                = StrictKits.kit(lines.one().execute(input), lines.two().execute(input));

        for(LineResult<?> result : results) {
            if(!result.succeeded())
                return new LineResultImpl<>(result.getError());
        }

        R value = partFactory.assemble(results.one().getValue(), results.two().getValue());

        return new LineResultImpl<>(value);
    }
}
