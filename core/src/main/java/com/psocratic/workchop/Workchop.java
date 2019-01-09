package com.psocratic.workchop;

import com.psocratic.workchop.line.LineFactories;
import com.psocratic.workchop.line.LineFactory;
import com.psocratic.workchop.spec.ExtensibleSpec;
import com.psocratic.workchop.spec.ExtensibleSpecs;
import com.psocratic.workchop.step.StepInstantiator;

/**
 * A facade for using various parts of the Workchop library.
 */
public final class Workchop {
    private Workchop() {}

    public static LineFactory lineFactory() {
        return LineFactories.basic();
    }

    public static LineFactory lineFactory(StepInstantiator stepInstantiator) {
        return LineFactories.basic(stepInstantiator);
    }

    /**
     *
     * Creates an intake {@link ExtensibleSpec} of type {@code I}.
     *
     * @param <I> The type of the input class
     * @return A new {@link ExtensibleSpec}
     */
    public static <I> ExtensibleSpec<I, I> spec() {
        return ExtensibleSpecs.intake();
    }
}
