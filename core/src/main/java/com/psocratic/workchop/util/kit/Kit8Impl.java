package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class Kit8Impl<E1, E2, E3, E4, E5, E6, E7, E8> extends Kit7Impl<E1, E2, E3, E4, E5, E6, E7> implements Kit8<E1, E2, E3, E4, E5, E6, E7, E8> {
    private final E8 e8;

    Kit8Impl(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7, E8 e8) {
        this(e1, e2, e3, e4, e5, e6, e7, e8, emptyList());
    }

    Kit8Impl(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7, E8 e8,  List<Object> remainder) {
        super(e1, e2, e3, e4, e5, e6, e7, concat(singletonList(e8), remainder));
        this.e8 = e8;
    }

    @Override
    public E8 eight() {
        return e8;
    }
}
