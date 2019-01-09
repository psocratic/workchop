package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit2;
import com.psocratic.workchop.util.kit.Kit2Assembler;
import com.psocratic.workchop.util.kit.StrictKit2;

/**
 * A {@link ParallelSpec} that composites at least two
 * {@link Spec} elements.
 *
 * @param <I> The input type of the {@link Spec}.
 * @param <E1> The output type of the first {@link Spec} element.
 * @param <E2> The output type of the second {@link Spec} element.
 * @param <R> The output type that aggregates the output types of all {@link Spec} elements.
 */
public interface Parallel2Spec<I, E1, E2, R extends Kit2<E1, E2>> extends ParallelSpec<I, R> {
    @Override
    default Parallelism getParallelism() {
        return Parallelism.TWO;
    }

    @Override
    Kit2Assembler<E1, E2, R> getKitAssembler();

    @Override
    StrictKit2<? extends Numbers.Two, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>> getSpecs();

    @Override
    default Parallel2Spec<I, E1, E2, R> toParallel2() {
        return this;
    }
}
