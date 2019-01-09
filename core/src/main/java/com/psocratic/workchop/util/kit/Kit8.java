package com.psocratic.workchop.util.kit;

/**
 * A kit with at least eight members.
 *
 * @param <E1> The type of the first member of the kit.
 * @param <E2> The type of the second member of the kit.
 * @param <E3> The type of the third member of the kit.
 * @param <E4> The type of the fourth member of the kit.
 * @param <E5> The type of the fifth member of the kit.
 * @param <E6> The type of the sixth member of the kit.
 * @param <E7> The type of the seventh member of the kit.
 * @param <E8> The type of the eighth member of the kit.
 */
public interface Kit8<E1, E2, E3, E4, E5, E6, E7, E8> extends Kit7<E1, E2, E3, E4, E5, E6, E7> {
    /**
     * @return The eighth member of the kit.
     */
    E8 eight();
}
