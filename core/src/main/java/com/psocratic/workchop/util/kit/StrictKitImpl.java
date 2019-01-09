package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Number;

import java.util.Iterator;
import java.util.List;

class StrictKitImpl<N extends Number, E> implements StrictKit<N, E> {
    private final List<E> elements;
    private final N size;

    StrictKitImpl(N size, List<E> elements) {
        this.elements = elements;
        this.size = size;
    }

    @Override
    public Iterator<E> iterator() {
        return elements.iterator();
    }
}
