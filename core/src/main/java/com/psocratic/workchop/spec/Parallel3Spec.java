package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit3;
import com.psocratic.workchop.util.kit.Kit3Assembler;
import com.psocratic.workchop.util.kit.StrictKit3;

/**
 * A {@link ParallelSpec} that composites at least three
 * {@link Spec} elements.
 *
 * @param <I> The input type of the {@link Spec}.
 * @param <E1> The output type of the first {@link Spec} element.
 * @param <E2> The output type of the second {@link Spec} element.
 * @param <E3> The output type of the third {@link Spec} element.
 * @param <R> The output type that aggregates the output types of all {@link Spec} elements.
 */
public interface Parallel3Spec<I, E1, E2, E3, R extends Kit3<E1, E2, E3>> extends ParallelSpec<I, R> {
    @Override
    default Parallelism getParallelism() {
        return Parallelism.THREE;
    }

    @Override
    StrictKit3<? extends Numbers.Three, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>> getSpecs();

    @Override
    Kit3Assembler<E1, E2, E3, R> getKitAssembler();

    @Override
    default Parallel3Spec<I, E1, E2, E3, R> toParallel3() {
        return this;
    }
}
