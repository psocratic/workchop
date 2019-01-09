package com.psocratic.workchop.spec;

import com.psocratic.workchop.step.Step;
import com.psocratic.workchop.util.InstanceOrType;

/**
 * Specifies a {@link Step}.
 */
public interface StepSpec<I, O> extends Spec<I, O> {
    @Override
    default SpecType getSpecType() {
        return SpecType.STEP;
    }

    /**
     * @return An instance-or-type of a {@link Step}.
     */
    InstanceOrType<Step<I, O>> getStep();

    default StepSpec<I, O> toStep() {
        return this;
    }
}
