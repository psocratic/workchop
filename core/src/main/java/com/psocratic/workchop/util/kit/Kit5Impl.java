package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class Kit5Impl<E1, E2, E3, E4, E5> extends Kit4Impl<E1, E2, E3, E4> implements Kit5<E1, E2, E3, E4, E5> {
    private final E5 e5;

    Kit5Impl(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5) {
        this(e1, e2, e3, e4, e5, emptyList());
    }

    Kit5Impl(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, List<Object> remainder) {
        super(e1, e2, e3, e4, concat(singletonList(e5), remainder));
        this.e5 = e5;
    }

    @Override
    public E5 five() {
        return e5;
    }
}
