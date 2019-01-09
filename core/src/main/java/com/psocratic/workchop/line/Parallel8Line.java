package com.psocratic.workchop.line;

import com.psocratic.workchop.util.kit.Kit8;
import com.psocratic.workchop.util.kit.Kit8Assembler;
import com.psocratic.workchop.util.kit.StrictKit8;

import static com.psocratic.workchop.util.kit.StrictKits.kit;

final class Parallel8Line<I, E1, E2, E3, E4, E5, E6, E7, E8, R extends Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> implements Line<I, R> {
    private final StrictKit8<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>,
                                            Line<I, E5>, Line<I, E6>, Line<I, E7>, Line<I, E8>> lines;
    private final Kit8Assembler<E1, E2, E3, E4, E5, E6, E7, E8, R> partFactory;

    Parallel8Line(StrictKit8<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>,
                                            Line<I, E5>, Line<I, E6>, Line<I, E7>, Line<I, E8>> lines,
                  Kit8Assembler<E1, E2, E3, E4, E5, E6, E7, E8, R> partFactory) {
        this.lines = lines;
        this.partFactory = partFactory;
    }

    @Override
    public LineResult<R> execute(I input) {
        StrictKit8<?, LineResult<?>, LineResult<E1>, LineResult<E2>, LineResult<E3>, LineResult<E4>,
                                         LineResult<E5>, LineResult<E6>, LineResult<E7>, LineResult<E8>> results
                = kit(lines.one().execute(input), lines.two().execute(input), lines.three().execute(input), lines.four().execute(input),
                        lines.five().execute(input), lines.six().execute(input), lines.seven().execute(input), lines.eight().execute(input));

        for(LineResult<?> result : results) {
            if(!result.succeeded())
                return new LineResultImpl<>(result.getError());
        }

        R value = partFactory.assemble(results.one().getValue(), results.two().getValue(), results.three().getValue(), results.four().getValue(),
                                      results.five().getValue(), results.six().getValue(), results.seven().getValue(), results.eight().getValue());

        return new LineResultImpl<>(value);
    }
}
