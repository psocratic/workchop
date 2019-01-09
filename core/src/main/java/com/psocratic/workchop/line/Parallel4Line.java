package com.psocratic.workchop.line;

import com.psocratic.workchop.util.kit.Kit4;
import com.psocratic.workchop.util.kit.Kit4Assembler;
import com.psocratic.workchop.util.kit.StrictKit4;
import com.psocratic.workchop.util.kit.StrictKits;

import static com.psocratic.workchop.util.kit.StrictKits.kit;

final class Parallel4Line<I, E1, E2, E3, E4, R extends Kit4<E1, E2, E3, E4>> implements Line<I, R> {
    private final StrictKit4<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>> lines;
    private final Kit4Assembler<E1, E2, E3, E4, R> partFactory;

    Parallel4Line(StrictKit4<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>> lines,
                  Kit4Assembler<E1, E2, E3, E4, R> partFactory) {
        this.lines = lines;
        this.partFactory = partFactory;
    }

    @Override
    public LineResult<R> execute(I input) {
        StrictKit4<?, LineResult<?>, LineResult<E1>, LineResult<E2>, LineResult<E3>, LineResult<E4>> results
                = StrictKits.kit(lines.one().execute(input), lines.two().execute(input), lines.three().execute(input), lines.four().execute(input));

        for(LineResult<?> result : results) {
            if(!result.succeeded())
                return new LineResultImpl<>(result.getError());
        }

        R value = partFactory.assemble(results.one().getValue(), results.two().getValue(), results.three().getValue(), results.four().getValue());

        return new LineResultImpl<>(value);
    }
}
