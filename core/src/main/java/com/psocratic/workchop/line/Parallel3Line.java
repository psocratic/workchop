package com.psocratic.workchop.line;

import com.psocratic.workchop.util.kit.Kit3;
import com.psocratic.workchop.util.kit.Kit3Assembler;
import com.psocratic.workchop.util.kit.StrictKit3;
import com.psocratic.workchop.util.kit.StrictKits;

import static com.psocratic.workchop.util.kit.StrictKits.kit;

final class Parallel3Line<I, E1, E2, E3, R extends Kit3<E1, E2, E3>> implements Line<I, R> {
    private final StrictKit3<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>> lines;
    private final Kit3Assembler<E1, E2, E3, R> partFactory;

    Parallel3Line(StrictKit3<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>> lines,
                  Kit3Assembler<E1, E2, E3, R> partFactory) {
        this.lines = lines;
        this.partFactory = partFactory;
    }

    @Override
    public LineResult<R> execute(I input) {
        StrictKit3<?, LineResult<?>, LineResult<E1>, LineResult<E2>, LineResult<E3>> results
                = StrictKits.kit(lines.one().execute(input), lines.two().execute(input), lines.three().execute(input));

        for(LineResult<?> result : results) {
            if(!result.succeeded())
                return new LineResultImpl<>(result.getError());
        }

        R value = partFactory.assemble(results.one().getValue(), results.two().getValue(), results.three().getValue());

        return new LineResultImpl<>(value);
    }
}
