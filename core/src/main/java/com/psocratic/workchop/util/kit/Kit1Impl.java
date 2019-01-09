package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

class Kit1Impl<E1> extends BaseKit implements Kit1<E1> {
    private final E1 e1;

    Kit1Impl(E1 e1) {
        this(e1, emptyList());
    }

    Kit1Impl(E1 e1, List<Object> remainder) {
        super(concat(singletonList(e1), remainder));
        this.e1 = e1;
    }

    @Override
    public E1 one() {
        return e1;
    }
}
