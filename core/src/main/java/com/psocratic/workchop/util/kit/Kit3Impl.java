package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class Kit3Impl<E1, E2, E3> extends Kit2Impl<E1, E2> implements Kit3<E1, E2, E3> {
    private final E3 e3;

    Kit3Impl(E1 e1, E2 e2, E3 e3) {
        this(e1, e2, e3, emptyList());
    }

    Kit3Impl(E1 e1, E2 e2, E3 e3, List<Object> remainder) {
        super(e1, e2, concat(singletonList(e3), remainder));
        this.e3 = e3;
    }

    @Override
    public E3 three() {
        return e3;
    }
}
