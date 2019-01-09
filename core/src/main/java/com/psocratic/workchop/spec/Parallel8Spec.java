package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit8;
import com.psocratic.workchop.util.kit.Kit8Assembler;
import com.psocratic.workchop.util.kit.StrictKit8;

/**
 * A {@link ParallelSpec} that composites at least eight
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
 * @param <E8> The output type of the eighth {@link Spec} element.
 * @param <R> The output type that aggregates the output types of all {@link Spec} elements.
 */
public interface Parallel8Spec<I, E1, E2, E3, E4, E5, E6, E7, E8, R extends Kit8<E1, E2, E3, E4, E5, E6, E7, E8>>
        extends ParallelSpec<I, R> {
    @Override
    default Parallelism getParallelism() {
        return Parallelism.EIGHT;
    }

    StrictKit8<? extends Numbers.Eight, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                    Spec<I, E5>, Spec<I, E6>, Spec<I, E7>, Spec<I, E8>> getSpecs();

    Kit8Assembler<E1, E2, E3, E4, E5, E6, E7, E8, R> getKitAssembler();

    @Override
    default Parallel8Spec<I, E1, E2, E3, E4, E5, E6, E7, E8, R> toParallel8() {
        return this;
    }
}
