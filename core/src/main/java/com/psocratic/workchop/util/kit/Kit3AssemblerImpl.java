package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;

class Kit3AssemblerImpl<E1, E2, E3> implements Kit3Assembler<E1, E2, E3, Kit3<E1, E2, E3>> {
    @Override
    public Kit3<E1, E2, E3> assemble(E1 e1, E2 e2, E3 e3) {
        return assemble(e1, e2, e3, emptyList());
    }

    Kit3<E1, E2, E3> assemble(E1 e1, E2 e2, E3 e3, List<Object> remainder) {
        return new Kit3Impl<>(e1, e2, e3, remainder);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Kit3<E1, E2, E3> assemble(List<Object> elements) {
        return assemble(
                (E1)elements.get(0),
                (E2)elements.get(1),
                (E3)elements.get(2),
                elements.subList(3, elements.size()));
    }
}
