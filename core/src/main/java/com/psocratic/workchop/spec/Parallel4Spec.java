package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit4;
import com.psocratic.workchop.util.kit.Kit4Assembler;
import com.psocratic.workchop.util.kit.StrictKit4;

/**
 * A {@link ParallelSpec} that composites at least four
 * {@link Spec} elements.
 *
 * @param <I> The input type of the {@link Spec}.
 * @param <E1> The output type of the first {@link Spec} element.
 * @param <E2> The output type of the second {@link Spec} element.
 * @param <E3> The output type of the third {@link Spec} element.
 * @param <E4> The output type of the fourth {@link Spec} element.
 * @param <R> The output type that aggregates the output types of all {@link Spec} elements.
 */
public interface Parallel4Spec<I, E1, E2, E3, E4, R extends Kit4<E1, E2, E3, E4>> extends ParallelSpec<I, R> {
    @Override
    default Parallelism getParallelism() {
        return Parallelism.FOUR;
    }

    @Override
    StrictKit4<? extends Numbers.Four, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>> getSpecs();

    @Override
    Kit4Assembler<E1, E2, E3, E4, R> getKitAssembler();

    @Override
    default Parallel4Spec<I, E1, E2, E3, E4, R> toParallel4() {
        return this;
    }
}
