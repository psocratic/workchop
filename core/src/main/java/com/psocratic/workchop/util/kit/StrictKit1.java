package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Numbers;

public interface StrictKit1<N extends Numbers.One, E, E1 extends E>
        extends StrictKit<N, E>, Kit1<E1> {}
