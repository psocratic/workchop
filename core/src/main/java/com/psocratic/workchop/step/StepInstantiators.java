package com.psocratic.workchop.step;

/**
 * A utility class for creating {@link StepInstantiator}.
 */
public final class StepInstantiators {
    private StepInstantiators() {}

    /**
     * @return A {@link StepInstantiator} that uses the class
     * default constructor to create a {@link Step}.
     */
    public static StepInstantiator byDefaultConstructor() {
        return DefaultConstructorStepInstantiator.INSTANCE;
    }
}
