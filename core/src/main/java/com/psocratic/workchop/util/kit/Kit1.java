package com.psocratic.workchop.util.kit;

/**
 * A kit with at least one member.
 *
 * @param <E1> The type of the first member of the kit.
 */
public interface Kit1<E1> extends Kit {
    /**
     * @return The first member of the kit.
     */
    E1 one();
}
