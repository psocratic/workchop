package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;

class Kit5AssemblerImpl<E1, E2, E3, E4, E5> implements Kit5Assembler<E1, E2, E3, E4, E5, Kit5<E1, E2, E3, E4, E5>> {
    @Override
    public Kit5<E1, E2, E3, E4, E5> assemble(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5) {
        return assemble(e1, e2, e3, e4, e5, emptyList());
    }

    Kit5<E1, E2, E3, E4, E5> assemble(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, List<Object> remainder) {
        return new Kit5Impl<>(e1, e2, e3, e4, e5, remainder);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Kit5<E1, E2, E3, E4, E5> assemble(List<Object> elements) {
        return assemble(
                (E1)elements.get(0),
                (E2)elements.get(1),
                (E3)elements.get(2),
                (E4)elements.get(3),
                (E5)elements.get(4),
                elements.subList(5, elements.size()));
    }
}
