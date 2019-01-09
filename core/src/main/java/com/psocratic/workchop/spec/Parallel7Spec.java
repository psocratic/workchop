package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit7;
import com.psocratic.workchop.util.kit.Kit7Assembler;
import com.psocratic.workchop.util.kit.StrictKit7;

/**
 * A {@link ParallelSpec} that composites at least seven
 * {@link Spec} elements.
 *
 * @param <I> The input type of the {@link Spec}.
 * @param <E1> The output type of the first {@link Spec} element.
 * @param <E2> The output type of the second {@link Spec} element.
 * @param <E3> The output type of the third {@link Spec} element.
 * @param <E4> The output type of the fourth {@link Spec} element.
 * @param <E5> The output type of the fifth {@link Spec} element.
 * @param <E6> The output type of the sixth {@link Spec} element.
 * @param <E7> The output type of the seventh {@link Spec} element.
 * @param <R> The output type that aggregates the output types of all {@link Spec} elements.
 */
public interface Parallel7Spec<I, E1, E2, E3, E4, E5, E6, E7, R extends Kit7<E1, E2, E3, E4, E5, E6, E7>>
        extends ParallelSpec<I, R> {
    @Override
    default Parallelism getParallelism() {
        return Parallelism.SEVEN;
    }

    @Override
    StrictKit7<? extends Numbers.Seven, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                    Spec<I, E5>, Spec<I, E6>, Spec<I, E7>> getSpecs();

    @Override
    Kit7Assembler<E1, E2, E3, E4, E5, E6, E7, R> getKitAssembler();

    @Override
    default Parallel7Spec<I, E1, E2, E3, E4, E5, E6, E7, R> toParallel7() {
        return this;
    }
}
