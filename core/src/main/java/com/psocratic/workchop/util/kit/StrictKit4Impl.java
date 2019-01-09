package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Numbers;

import java.util.List;

import static java.util.Collections.emptyList;

class StrictKit4Impl<N extends Numbers.Four, E, E1 extends E, E2 extends E, E3 extends E, E4 extends E>
        extends StrictKit3Impl<N, E, E1, E2, E3>
        implements StrictKit4<N, E, E1, E2, E3, E4> {
    private final E4 four;

    StrictKit4Impl(N size, E1 e1, E2 e2, E3 e3, E4 e4) {
        this(size, e1, e2, e3, e4, emptyList());
    }

    StrictKit4Impl(N size, E1 e1, E2 e2, E3 e3, E4 e4, List<E> es) {
        super(size, e1, e2, e3, asList(e4, es));
        this.four = e4;
    }

    @Override
    public E4 four() {
        return four;
    }
}
