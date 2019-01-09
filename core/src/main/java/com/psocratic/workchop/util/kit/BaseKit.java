package com.psocratic.workchop.util.kit;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

class BaseKit implements Kit {
    private final List<Object> elements;

    BaseKit(List<Object> elements) {
        this.elements = unmodifiableList(elements);
    }

    static List<Object> concat(List<Object> l1, List<Object> l2) {
        List<Object> combined = new ArrayList<>();
        combined.addAll(l1);
        combined.addAll(l2);
        return combined;
    }
}
