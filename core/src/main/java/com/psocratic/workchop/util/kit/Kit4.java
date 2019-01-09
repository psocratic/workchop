package com.psocratic.workchop.util.kit;

/**
 * A kit with at least four members.
 *
 *
 * @param <E1> The type of the first member of the kit.
 * @param <E2> The type of the second member of the kit.
 * @param <E3> The type of the third member of the kit.
 * @param <E4> The type of the fourth member of the kit.
 */
public interface Kit4<E1, E2, E3, E4> extends Kit3<E1, E2, E3> {
    /**
     * @return The fourth member of the kit.
     */
    E4 four();
}
