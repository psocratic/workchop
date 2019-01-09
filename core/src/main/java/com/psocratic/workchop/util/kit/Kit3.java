package com.psocratic.workchop.util.kit;

/**
 * A kit with at least three members.
 *
 * @param <E1> The type of the first member of the kit.
 * @param <E2> The type of the second member of the kit.
 * @param <E3> The type of the third member of the kit.
 */
public interface Kit3<E1, E2, E3> extends Kit2<E1, E2> {
    /**
     * @return The third member of the kit.
     */
    E3 three();
}
