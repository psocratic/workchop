package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;

class Kit2AssemblerImpl<E1, E2> implements Kit2Assembler<E1, E2, Kit2<E1, E2>> {
    @Override
    public Kit2<E1, E2> assemble(E1 e1, E2 e2) {
        return assemble(e1, e2, emptyList());
    }

    Kit2<E1, E2> assemble(E1 e1, E2 e2, List<Object> remainder) {
        return new Kit2Impl<>(e1, e2, remainder);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Kit2<E1, E2> assemble(List<Object> elements) {
        return assemble(
                (E1)elements.get(0),
                (E2)elements.get(1),
                elements.subList(2, elements.size()));
    }
}
