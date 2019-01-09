package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.line.Line;

/**
 * A "kit" is an aggregate of objects that offers a
 * dedicated accessor for each guaranteed member.
 * Kits are used to aggregate the results of {@link Line}
 * that produce parallel output.
 *
 * The base {@link Kit} interface has no guaranteed
 * member, so it does not have any dedicated accessors.
 */
interface Kit {
}
