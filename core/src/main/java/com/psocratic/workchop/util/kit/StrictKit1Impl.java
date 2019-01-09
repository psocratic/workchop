package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Numbers;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

class StrictKit1Impl<N extends Numbers.One, E, E1 extends E>
        extends StrictKitImpl<N, E>
        implements StrictKit1<N, E, E1> {
    private final E1 one;

    StrictKit1Impl(N size, E1 e1) {
        this(size, e1, emptyList());
    }

    StrictKit1Impl(N size, E1 e1, List<E> es) {
        super(size, asList(e1, es));
        this.one = e1;
    }

    @Override
    public E1 one() {
        return one;
    }

    static <E1 extends E, E> List<E> asList(E1 e1, List<E> es) {
        List<E> list = new ArrayList<>();
        list.add(e1);
        list.addAll(es);
        return list;
    }
}
