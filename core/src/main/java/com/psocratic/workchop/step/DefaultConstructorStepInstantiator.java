package com.psocratic.workchop.step;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.util.Optional;
import java.util.stream.Stream;

final class DefaultConstructorStepInstantiator implements StepInstantiator {
    static final DefaultConstructorStepInstantiator INSTANCE = new DefaultConstructorStepInstantiator();

    @Override
    public <I, R> Step<I, R> instantiate(Class<Step<I, R>> stageCls) throws StepInstantiationException {
        final Optional<Constructor<?>> maybeConstructor
            = Stream.of(stageCls.getDeclaredConstructors())
                .filter(c -> c.getParameterCount() == 0)
                .findFirst();

        final Constructor<?> constructor;
        if(!maybeConstructor.isPresent()) {
            throw new StepInstantiationException("Step class does not have a zero-args constructor: " + stageCls);
        } else {
            constructor = maybeConstructor.get();
        }

        try {
            AccessibleObject.setAccessible(new AccessibleObject[]{constructor}, true);
            constructor.setAccessible(true);
            return stageCls.cast(constructor.newInstance());
        } catch(final Exception e) {
            throw new StepInstantiationException("Failed to instantiate: " + stageCls, e);
        }
    }
}
