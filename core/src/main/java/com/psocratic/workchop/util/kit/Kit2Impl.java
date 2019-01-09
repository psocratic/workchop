package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class Kit2Impl<E1, E2> extends Kit1Impl<E1> implements Kit2<E1, E2> {
    private final E2 e2;

    Kit2Impl(E1 e1, E2 e2) {
        this(e1, e2, emptyList());
    }

    Kit2Impl(E1 e1, E2 e2, List<Object> remainder) {
        super(e1, concat(singletonList(e2), remainder));
        this.e2 = e2;
    }

    @Override
    public E2 two() {
        return e2;
    }
}
