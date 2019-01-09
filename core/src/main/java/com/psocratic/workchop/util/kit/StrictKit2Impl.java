package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Numbers;

import java.util.List;

import static java.util.Collections.emptyList;

class StrictKit2Impl<N extends Numbers.Two, E, E1 extends E, E2 extends E>
        extends StrictKit1Impl<N, E, E1>
        implements StrictKit2<N, E, E1, E2> {
    private final E2 two;

    StrictKit2Impl(N size, E1 e1, E2 e2) {
        this(size, e1, e2, emptyList());
    }

    StrictKit2Impl(N size, E1 e1, E2 e2, List<E> es) {
        super(size, e1, asList(e2, es));
        this.two = e2;
    }

    @Override
    public E2 two() {
        return two;
    }
}
