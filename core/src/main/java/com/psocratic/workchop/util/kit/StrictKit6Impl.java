package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Numbers;

import java.util.List;

import static java.util.Collections.emptyList;

class StrictKit6Impl<N extends Numbers.Six, E, E1 extends E, E2 extends E, E3 extends E, E4 extends E,
                                           E5 extends E, E6 extends E>
        extends StrictKit5Impl<N, E, E1, E2, E3, E4, E5>
        implements StrictKit6<N, E, E1, E2, E3, E4, E5, E6> {
    private final E6 six;

    StrictKit6Impl(N size, E1 e1, E2 e2, E3 e3, E4 e4,
                   E5 e5, E6 e6) {
        this(size, e1, e2, e3, e4, e5, e6, emptyList());
    }

    StrictKit6Impl(N size, E1 e1, E2 e2, E3 e3, E4 e4,
                   E5 e5, E6 e6, List<E> es) {
        super(size, e1, e2, e3, e4, e5, asList(e6, es));
        this.six = e6;
    }

    @Override
    public E6 six() {
        return six;
    }
}
