package com.psocratic.workchop.line;

import com.psocratic.workchop.step.Step;
import com.psocratic.workchop.step.StepInstantiator;

/**
 * A utility class for instantiating built-in line factories.
 */
public final class LineFactories {
    private LineFactories() {}

    /**
     * @return The basic built-in line factory.
     */
    public static LineFactory basic() {
        return BasicLineFactory.INSTANCE;
    }

    /**
     * @param stepInstantiator The {@link StepInstantiator} to use for instantiating any
     *                        class-based {@link Step} encountered by the resulting
     *                        {@link LineFactory} during {@link Line} creation.
     * @return The basic built-in line factory, modified to use a custom step instantiator.
     */
    public static LineFactory basic(StepInstantiator stepInstantiator) {
        return new BasicLineFactory(stepInstantiator);
    }
}
