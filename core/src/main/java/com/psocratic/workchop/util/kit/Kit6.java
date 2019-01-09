package com.psocratic.workchop.util.kit;

/**
 * A kit with at least six members.
 *
 *
 * @param <E1> The type of the first member of the kit.
 * @param <E2> The type of the second member of the kit.
 * @param <E3> The type of the third member of the kit.
 * @param <E4> The type of the fourth member of the kit.
 * @param <E5> The type of the fifth member of the kit.
 * @param <E6> The type of the sixth member of the kit.
 */
public interface Kit6<E1, E2, E3, E4, E5, E6> extends Kit5<E1, E2, E3, E4, E5> {
    /**
     * @return The sixth member of the kit.
     */
    E6 six();
}
