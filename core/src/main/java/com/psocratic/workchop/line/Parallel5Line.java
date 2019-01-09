package com.psocratic.workchop.line;

import com.psocratic.workchop.util.kit.Kit5;
import com.psocratic.workchop.util.kit.Kit5Assembler;
import com.psocratic.workchop.util.kit.StrictKit5;
import com.psocratic.workchop.util.kit.StrictKits;

import static com.psocratic.workchop.util.kit.StrictKits.kit;

final class Parallel5Line<I, E1, E2, E3, E4, E5, R extends Kit5<E1, E2, E3, E4, E5>> implements Line<I, R> {
    private final StrictKit5<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>,
                                            Line<I, E5>> lines;
    private final Kit5Assembler<E1, E2, E3, E4, E5, R> partFactory;

    Parallel5Line(StrictKit5<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>,
                                            Line<I, E5>> lines,
                  Kit5Assembler<E1, E2, E3, E4, E5, R> partFactory) {
        this.lines = lines;
        this.partFactory = partFactory;
    }

    @Override
    public LineResult<R> execute(I input) {
        StrictKit5<?, LineResult<?>, LineResult<E1>, LineResult<E2>, LineResult<E3>, LineResult<E4>,
                                         LineResult<E5>> results
                = StrictKits.kit(lines.one().execute(input), lines.two().execute(input), lines.three().execute(input), lines.four().execute(input),
                        lines.five().execute(input));

        for(LineResult<?> result : results) {
            if(!result.succeeded())
                return new LineResultImpl<>(result.getError());
        }

        R value = partFactory.assemble(results.one().getValue(), results.two().getValue(), results.three().getValue(), results.four().getValue(),
                                      results.five().getValue());

        return new LineResultImpl<>(value);
    }
}
