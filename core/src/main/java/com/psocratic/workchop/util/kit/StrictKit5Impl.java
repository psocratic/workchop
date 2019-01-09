package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Numbers;

import java.util.List;

import static java.util.Collections.emptyList;

class StrictKit5Impl<N extends Numbers.Five, E, E1 extends E, E2 extends E, E3 extends E, E4 extends E,
                                            E5 extends E>
        extends StrictKit4Impl<N, E, E1, E2, E3, E4>
        implements StrictKit5<N, E, E1, E2, E3, E4, E5> {
    private final E5 five;

    StrictKit5Impl(N size, E1 e1, E2 e2, E3 e3, E4 e4,
                   E5 e5) {
        this(size, e1, e2, e3, e4, e5, emptyList());
    }

    StrictKit5Impl(N size, E1 e1, E2 e2, E3 e3, E4 e4,
                   E5 e5, List<E> es) {
        super(size, e1, e2, e3, e4, asList(e5, es));
        this.five = e5;
    }

    @Override
    public E5 five() {
        return five;
    }
}
