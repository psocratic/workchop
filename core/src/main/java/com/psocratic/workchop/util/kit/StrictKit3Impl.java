package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Numbers;

import java.util.List;

import static java.util.Collections.emptyList;

class StrictKit3Impl<N extends Numbers.Three, E, E1 extends E, E2 extends E, E3 extends E>
        extends StrictKit2Impl<N, E, E1, E2>
        implements StrictKit3<N, E, E1, E2, E3> {
    private final E3 three;

    StrictKit3Impl(N size, E1 e1, E2 e2, E3 e3) {
        this(size, e1, e2, e3, emptyList());
    }

    StrictKit3Impl(N size, E1 e1, E2 e2, E3 e3, List<E> es) {
        super(size, e1, e2, asList(e3, es));
        this.three = e3;
    }

    @Override
    public E3 three() {
        return three;
    }
}
