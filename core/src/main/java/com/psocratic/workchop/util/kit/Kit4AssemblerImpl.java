package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;

class Kit4AssemblerImpl<E1, E2, E3, E4> implements Kit4Assembler<E1, E2, E3, E4, Kit4<E1, E2, E3, E4>> {
    @Override
    public Kit4<E1, E2, E3, E4> assemble(E1 e1, E2 e2, E3 e3, E4 e4) {
        return assemble(e1, e2, e3, e4, emptyList());
    }

    Kit4<E1, E2, E3, E4> assemble(E1 e1, E2 e2, E3 e3, E4 e4, List<Object> remainder) {
        return new Kit4Impl<>(e1, e2, e3, e4, remainder);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Kit4<E1, E2, E3, E4> assemble(List<Object> elements) {
        return assemble(
                (E1)elements.get(0),
                (E2)elements.get(1),
                (E3)elements.get(2),
                (E4)elements.get(3),
                elements.subList(4, elements.size()));
    }
}
