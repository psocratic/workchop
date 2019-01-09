package com.psocratic.workchop.spec;

import com.psocratic.workchop.line.Line;
import com.psocratic.workchop.step.Step;

/**
 * A {@link Spec} is a blue print for a {@link Line}. A spec can either
 * represent a {@link Step} or a be an aggregation of other {@link Spec}
 * elements. Another way to look at it is that {@link Spec} elements are
 * tree nodes, the leaves of which are all {@link StepSpec}, and the
 * branches of which are all {@link CompositeSpec}.
 *
 * @param <I> The input type of a {@link Spec}
 * @param <O> The output type of a {@link Spec}
 */
public interface Spec<I, O> {
    enum SpecType {
        COMPOSITE,
        STEP
    }

    default SpecType getSpecType() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @return When the {@link SpecType} is {@link SpecType#COMPOSITE}, refines
     * this to a {@link CompositeSpec}. Otherwise, the behavior is undefined.
     */
    default CompositeSpec<I, O> toComposite() {
        throw new UnsupportedOperationException("Not implemented");
    }

    /**
     * @return When the {@link SpecType} is {@link SpecType#STEP}, refines
     * this to a {@link StepSpec}. Otherwise, the behavior is undefined.
     */
    default StepSpec<I, O> toStep() {
        throw new UnsupportedOperationException("Not implemented");
    }

}
