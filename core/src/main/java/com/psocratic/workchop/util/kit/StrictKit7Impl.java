package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Numbers;

import java.util.List;

import static java.util.Collections.emptyList;

class StrictKit7Impl<N extends Numbers.Seven, E, E1 extends E, E2 extends E, E3 extends E, E4 extends E,
                                             E5 extends E, E6 extends E, E7 extends E>
        extends StrictKit6Impl<N, E, E1, E2, E3, E4, E5, E6>
        implements StrictKit7<N, E, E1, E2, E3, E4, E5, E6, E7> {
    private final E7 seven;

    StrictKit7Impl(N size, E1 e1, E2 e2, E3 e3, E4 e4,
                   E5 e5, E6 e6, E7 e7) {
        this(size, e1, e2, e3, e4, e5, e6, e7, emptyList());
    }

    StrictKit7Impl(N size, E1 e1, E2 e2, E3 e3, E4 e4,
                   E5 e5, E6 e6, E7 e7, List<E> es) {
        super(size, e1, e2, e3, e4, e5, e6, asList(e7, es));
        this.seven = e7;
    }

    @Override
    public E7 seven() {
        return seven;
    }
}
