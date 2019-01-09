package com.psocratic.workchop.line;

import com.psocratic.workchop.util.kit.Kit7;
import com.psocratic.workchop.util.kit.Kit7Assembler;
import com.psocratic.workchop.util.kit.StrictKit7;
import com.psocratic.workchop.util.kit.StrictKits;

import static com.psocratic.workchop.util.kit.StrictKits.kit;

final class Parallel7Line<I, E1, E2, E3, E4, E5, E6, E7, R extends Kit7<E1, E2, E3, E4, E5, E6, E7>> implements Line<I, R> {
    private final StrictKit7<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>,
                                            Line<I, E5>, Line<I, E6>, Line<I, E7>> lines;
    private final Kit7Assembler<E1, E2, E3, E4, E5, E6, E7, R> partFactory;

    Parallel7Line(StrictKit7<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>,
                                            Line<I, E5>, Line<I, E6>, Line<I, E7>> lines,
                  Kit7Assembler<E1, E2, E3, E4, E5, E6, E7, R> partFactory) {
        this.lines = lines;
        this.partFactory = partFactory;
    }

    @Override
    public LineResult<R> execute(I input) {
        StrictKit7<?, LineResult<?>, LineResult<E1>, LineResult<E2>, LineResult<E3>, LineResult<E4>,
                                         LineResult<E5>, LineResult<E6>, LineResult<E7>> results
                = StrictKits.kit(lines.one().execute(input), lines.two().execute(input), lines.three().execute(input), lines.four().execute(input),
                        lines.five().execute(input), lines.six().execute(input), lines.seven().execute(input));

        for(LineResult<?> result : results) {
            if(!result.succeeded())
                return new LineResultImpl<>(result.getError());
        }

        R value = partFactory.assemble(results.one().getValue(), results.two().getValue(), results.three().getValue(), results.four().getValue(),
                                      results.five().getValue(), results.six().getValue(), results.seven().getValue());

        return new LineResultImpl<>(value);
    }
}
