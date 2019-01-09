package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;

class Kit7AssemblerImpl<E1, E2, E3, E4, E5, E6, E7> implements Kit7Assembler<E1, E2, E3, E4, E5, E6, E7, Kit7<E1, E2, E3, E4, E5, E6, E7>> {
    @Override
    public Kit7<E1, E2, E3, E4, E5, E6, E7> assemble(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7) {
        return assemble(e1, e2, e3, e4, e5, e6, e7, emptyList());
    }

    Kit7<E1, E2, E3, E4, E5, E6, E7> assemble(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7, List<Object> remainder) {
        return new Kit7Impl<>(e1, e2, e3, e4, e5, e6, e7, remainder);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Kit7<E1, E2, E3, E4, E5, E6, E7> assemble(List<Object> elements) {
        return assemble(
                (E1)elements.get(0),
                (E2)elements.get(1),
                (E3)elements.get(2),
                (E4)elements.get(3),
                (E5)elements.get(4),
                (E6)elements.get(5),
                (E7)elements.get(6),
                elements.subList(7, elements.size()));
    }
}
