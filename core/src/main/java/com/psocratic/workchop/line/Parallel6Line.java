package com.psocratic.workchop.line;

import com.psocratic.workchop.util.kit.Kit6;
import com.psocratic.workchop.util.kit.Kit6Assembler;
import com.psocratic.workchop.util.kit.StrictKit6;
import com.psocratic.workchop.util.kit.StrictKits;

import static com.psocratic.workchop.util.kit.StrictKits.kit;

final class Parallel6Line<I, E1, E2, E3, E4, E5, E6, R extends Kit6<E1, E2, E3, E4, E5, E6>> implements Line<I, R> {
    private final StrictKit6<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>,
                                            Line<I, E5>, Line<I, E6>> lines;
    private final Kit6Assembler<E1, E2, E3, E4, E5, E6, R> partFactory;

    Parallel6Line(StrictKit6<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>,
                                            Line<I, E5>, Line<I, E6>> lines,
                  Kit6Assembler<E1, E2, E3, E4, E5, E6, R> partFactory) {
        this.lines = lines;
        this.partFactory = partFactory;
    }

    @Override
    public LineResult<R> execute(I input) {
        StrictKit6<?, LineResult<?>, LineResult<E1>, LineResult<E2>, LineResult<E3>, LineResult<E4>,
                                         LineResult<E5>, LineResult<E6>> results
                = StrictKits.kit(lines.one().execute(input), lines.two().execute(input), lines.three().execute(input), lines.four().execute(input),
                        lines.five().execute(input), lines.six().execute(input));

        for(LineResult<?> result : results) {
            if(!result.succeeded())
                return new LineResultImpl<>(result.getError());
        }

        R value = partFactory.assemble(results.one().getValue(), results.two().getValue(), results.three().getValue(), results.four().getValue(),
                                      results.five().getValue(), results.six().getValue());

        return new LineResultImpl<>(value);
    }
}
