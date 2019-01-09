package com.psocratic.workchop.step;

/**
 * Instantiates {@link Step} from classes.
 */
public interface StepInstantiator {
    /**
     * @param stepCls The class of the step to instantiate.
     * @param <I> The input type of the target step.
     * @param <R> The output type of the target step.
     * @return An instantiated {@link Step}
     * @throws StepInstantiationException When an error occurs while
     * instantiating a {@link Step}.
     */
    <I, R> Step<I, R> instantiate(Class<Step<I, R>> stepCls) throws StepInstantiationException;
}