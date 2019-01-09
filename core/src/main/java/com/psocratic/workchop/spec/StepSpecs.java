package com.psocratic.workchop.spec;

import com.psocratic.workchop.step.Step;

/**
 * A utility class for creating instances of {@link StepSpec}.
 */
public final class StepSpecs {
    private StepSpecs() {}

    /**
     * @param step The step to enclose in a {@link Spec}
     * @param <I> The input type of the step.
     * @param <R> The output type of the step.
     * @return A {@link Spec} enclosing the {@link Step}.
     */
    public static <I, R> StepSpec<I, R> create(Step<I, R> step) {
        return new StepSpecImpl<>(step);
    }

    /**
     * @param stepCls The step class to enclose in a {@link Spec}
     * @param <I> The input type of the step class.
     * @param <R> The output type of the step class.
     * @return A {@link Spec} enclosing the step class.
     */
    public static <I, R> StepSpec<I, R> create(Class<Step<I, R>> stepCls) {
        return new StepSpecImpl<>(stepCls);
    }
}
