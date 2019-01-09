package com.psocratic.workchop.util;

import java.util.Optional;

public final class InstanceOrType<X> {
    private final Class<X> classOfX;
    private final X instanceOfX;

    private InstanceOrType(final Class<X> classOfX) {
        this.classOfX = classOfX;
        this.instanceOfX = null;
    }

    private InstanceOrType(final X instanceOfX) {
        this.classOfX = null;
        this.instanceOfX = instanceOfX;
    }

    public Optional<Class<X>> getType() {
        return Optional.ofNullable(classOfX);
    }

    public Optional<X> getInstance() {
        return Optional.ofNullable(instanceOfX);
    }

    public boolean isInstance() {
        return instanceOfX != null;
    }

    public boolean isType() {
        return classOfX != null;
    }

    public static <T> InstanceOrType<T> instance(T instance) {
        return new InstanceOrType<>(instance);
    }

    public static <T> InstanceOrType<T> type(Class<T> type) {
        return new InstanceOrType<>(type);
    }
}
