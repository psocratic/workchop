package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class Kit6Impl<E1, E2, E3, E4, E5, E6> extends Kit5Impl<E1, E2, E3, E4, E5> implements Kit6<E1, E2, E3, E4, E5, E6> {
    private final E6 e6;

    Kit6Impl(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6) {
        this(e1, e2, e3, e4, e5, e6, emptyList());
    }

    Kit6Impl(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, List<Object> remainder) {
        super(e1, e2, e3, e4, e5, concat(singletonList(e6), remainder));
        this.e6 = e6;
    }

    @Override
    public E6 six() {
        return e6;
    }
}
