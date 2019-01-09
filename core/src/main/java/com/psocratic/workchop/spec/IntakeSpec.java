package com.psocratic.workchop.spec;

import com.psocratic.workchop.step.Step;
import com.psocratic.workchop.step.Steps;
import com.psocratic.workchop.util.InstanceOrType;

final class IntakeSpec<I> implements StepSpec<I, I> {
    private final InstanceOrType<Step<I, I>> step;

    IntakeSpec() {
        this.step = InstanceOrType.instance(Steps.intake());
    }

    @Override
    public InstanceOrType<Step<I, I>> getStep() {
        return step;
    }
}
