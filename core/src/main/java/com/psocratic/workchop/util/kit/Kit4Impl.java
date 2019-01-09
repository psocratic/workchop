package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class Kit4Impl<E1, E2, E3, E4> extends Kit3Impl<E1, E2, E3> implements Kit4<E1, E2, E3, E4> {
    private final E4 e4;

    Kit4Impl(E1 e1, E2 e2, E3 e3, E4 e4) {
        this(e1, e2, e3, e4, emptyList());
    }

    Kit4Impl(E1 e1, E2 e2, E3 e3, E4 e4, List<Object> remainder) {
        super(e1, e2, e3, concat(singletonList(e4), remainder));
        this.e4 = e4;
    }

    @Override
    public E4 four() {
        return e4;
    }
}
