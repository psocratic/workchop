package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Numbers;

public interface StrictKit2<N extends Numbers.Two, E, E1 extends E, E2 extends E>
        extends StrictKit1<N, E, E1>, Kit2<E1, E2> {}
