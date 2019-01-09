package com.psocratic.workchop.util.kit;

/**
 * A kit with at least two members.
 *
 * @param <E1> The type of the first member of the kit.
 * @param <E2> The type of the second member of the kit.
 */
public interface Kit2<E1, E2> extends Kit1<E1> {
    /**
     * @return The second member of the kit.
     */
    E2 two();
}