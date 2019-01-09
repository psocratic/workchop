package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Number;

/**
 * A {@link StrictKit} extends {@link Kit} by encoding
 * the kit size as well as the base type shared by all
 * members as type information.
 *
 * @param <N> The size of the kit.
 * @param <E> The base type shared by all members of the kit.
 */
public interface StrictKit<N extends Number, E> extends Iterable<E>, Kit {
}
