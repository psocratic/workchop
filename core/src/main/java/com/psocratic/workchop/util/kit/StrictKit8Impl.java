package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Numbers;

import java.util.List;

import static java.util.Collections.emptyList;

class StrictKit8Impl<N extends Numbers.Eight, E, E1 extends E, E2 extends E, E3 extends E, E4 extends E,
                                             E5 extends E, E6 extends E, E7 extends E, E8 extends E>
        extends StrictKit7Impl<N, E, E1, E2, E3, E4, E5, E6, E7>
        implements StrictKit8<N, E, E1, E2, E3, E4, E5, E6, E7, E8> {
    private final E8 eight;

    StrictKit8Impl(N size, E1 e1, E2 e2, E3 e3, E4 e4,
                   E5 e5, E6 e6, E7 e7, E8 e8) {
        this(size, e1, e2, e3, e4, e5, e6, e7, e8, emptyList());
    }

    StrictKit8Impl(N size, E1 e1, E2 e2, E3 e3, E4 e4,
                   E5 e5, E6 e6, E7 e7, E8 e8, List<E> es) {
        super(size, e1, e2, e3, e4, e5, e6, e7, asList(e8, es));
        this.eight = e8;
    }

    @Override
    public E8 eight() {
        return eight;
    }
}
