package com.psocratic.workchop.spec;

import com.psocratic.workchop.step.Step;
import com.psocratic.workchop.util.InstanceOrType;

final class StepSpecImpl<I, O> implements StepSpec<I, O> {
    private final InstanceOrType<Step<I, O>> stepInstanceOrType;

    StepSpecImpl(Step<I, O> stepInstance) {
        stepInstanceOrType = InstanceOrType.instance(stepInstance);
    }

    StepSpecImpl(Class<Step<I, O>> stepCls) {
        stepInstanceOrType = InstanceOrType.type(stepCls);
    }

    @Override
    public InstanceOrType<Step<I, O>> getStep() {
        return stepInstanceOrType;
    }
}
