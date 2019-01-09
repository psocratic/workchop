package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class Kit7Impl<E1, E2, E3, E4, E5, E6, E7> extends Kit6Impl<E1, E2, E3, E4, E5, E6> implements Kit7<E1, E2, E3, E4, E5, E6, E7> {
    private final E7 e7;

    Kit7Impl(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7) {
        this(e1, e2, e3, e4, e5, e6, e7, emptyList());
    }

    Kit7Impl(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7, List<Object> remainder) {
        super(e1, e2, e3, e4, e5, e6, concat(singletonList(e7), remainder));
        this.e7 = e7;
    }

    @Override
    public E7 seven() {
        return e7;
    }
}
