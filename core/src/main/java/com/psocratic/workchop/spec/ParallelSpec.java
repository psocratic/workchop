package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit2;
import com.psocratic.workchop.util.kit.KitAssembler;
import com.psocratic.workchop.util.kit.StrictKit;

/**
 * A {@link CompositeSpec} that arranges {@link Spec} elements in parallel,
 * with an output type that is an aggregation of the output types of its
 * {@link Spec} elements.
 *
 * @param <I> The input type of the {@link ParallelSpec}.
 * @param <R> The output type, which aggregates the types of {@link Spec} elements.
 */
public interface ParallelSpec<I, R extends Kit2<?, ?>> extends CompositeSpec<I, R> {
    enum Parallelism {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT
    }

    @Override
    default CompositionMode getCompositionMode() {
        return CompositionMode.PARALLEL;
    }

    /**
     * @return The number of {@link Spec} elements arranged into a composite.
     */
    default Parallelism getParallelism() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @return a {@link KitAssembler} that can be used to assemble the
     * instances element output types, and produce an instance of the aggregate
     * output type.
     */
    KitAssembler<R> getKitAssembler();

    /**
     * @return The {@link Spec} elements.
     */
    StrictKit<? extends Numbers.Two, Spec<I, ?>> getSpecs();

    @Override
    default ParallelSpec<I, R> toParallel() {
        return this;
    }

    /**
     * @return When the {@link Parallelism} is {@link Parallelism#TWO},
     * refines this to a {@link Parallel2Spec}. Otherwise, the behavior
     * is undefined.
     */
    default Parallel2Spec<I, ?, ?, ? extends R> toParallel2() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @return When the {@link Parallelism} is {@link Parallelism#THREE},
     * refines this to a {@link Parallel3Spec}. Otherwise, the behavior
     * is undefined.
     */
    default Parallel3Spec<I, ?, ?, ?, ? extends R> toParallel3() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @return When the {@link Parallelism} is {@link Parallelism#FOUR},
     * refines this to a {@link Parallel4Spec}. Otherwise, the behavior
     * is undefined.
     */
    default Parallel4Spec<I, ?, ?, ?, ?, ? extends R> toParallel4() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @return When the {@link Parallelism} is {@link Parallelism#FIVE},
     * refines this to a {@link Parallel5Spec}. Otherwise, the behavior
     * is undefined.
     */
    default Parallel5Spec<I, ?, ?, ?, ?, ?, ? extends R> toParallel5() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @return When the {@link Parallelism} is {@link Parallelism#SIX},
     * refines this to a {@link Parallel6Spec}. Otherwise, the behavior
     * is undefined.
     */
    default Parallel6Spec<I, ?, ?, ?, ?, ?, ?, ? extends R> toParallel6() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @return When the {@link Parallelism} is {@link Parallelism#SEVEN},
     * refines this to a {@link Parallel7Spec}. Otherwise, the behavior
     * is undefined.
     */
    default Parallel7Spec<I, ?, ?, ?, ?, ?, ?, ?, ? extends R> toParallel7() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @return When the {@link Parallelism} is {@link Parallelism#EIGHT},
     * refines this to a {@link Parallel8Spec}. Otherwise, the behavior
     * is undefined.
     */
    default Parallel8Spec<I, ?, ?, ?, ?, ?, ?, ?, ?, ? extends R> toParallel8() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
