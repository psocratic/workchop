package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit5;
import com.psocratic.workchop.util.kit.Kit5Assembler;
import com.psocratic.workchop.util.kit.StrictKit5;

/**
 * A {@link ParallelSpec} that composites at least five
 * {@link Spec} elements.
 *
 * @param <I> The input type of the {@link Spec}.
 * @param <E1> The output type of the first {@link Spec} element.
 * @param <E2> The output type of the second {@link Spec} element.
 * @param <E3> The output type of the third {@link Spec} element.
 * @param <E4> The output type of the fourth {@link Spec} element.
 * @param <E5> The output type of the fifth {@link Spec} element.
 * @param <R> The output type that aggregates the output types of all {@link Spec} elements.
 */
public interface Parallel5Spec<I, E1, E2, E3, E4, E5, R extends Kit5<E1, E2, E3, E4, E5>> extends ParallelSpec<I, R> {
    @Override
    default Parallelism getParallelism() {
        return Parallelism.FIVE;
    }

    @Override
    StrictKit5<? extends Numbers.Five, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                   Spec<I, E5>> getSpecs();

    @Override
    Kit5Assembler<E1, E2, E3, E4, E5, R> getKitAssembler();

    @Override
    default Parallel5Spec<I, E1, E2, E3, E4, E5, R> toParallel5() {
        return this;
    }
}
