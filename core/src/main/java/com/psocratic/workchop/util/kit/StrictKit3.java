package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Numbers;

public interface StrictKit3<N extends Numbers.Three, E, E1 extends E, E2 extends E, E3 extends E>
        extends StrictKit2<N, E, E1, E2>, Kit3<E1, E2, E3> {
}
