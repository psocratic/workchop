package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;

class Kit8AssemblerImpl<E1, E2, E3, E4, E5, E6, E7, E8> implements Kit8Assembler<E1, E2, E3, E4, E5, E6, E7, E8, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> {
    @Override
    public Kit8<E1, E2, E3, E4, E5, E6, E7, E8> assemble(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7, E8 e8) {
        return assemble(e1, e2, e3, e4, e5, e6, e7, e8, emptyList());
    }

    Kit8<E1, E2, E3, E4, E5, E6, E7, E8> assemble(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7, E8 e8, List<Object> remainder) {
        return new Kit8Impl<>(e1, e2, e3, e4, e5, e6, e7, e8, remainder);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Kit8<E1, E2, E3, E4, E5, E6, E7, E8> assemble(List<Object> elements) {
        return assemble(
                (E1)elements.get(0),
                (E2)elements.get(1),
                (E3)elements.get(2),
                (E4)elements.get(3),
                (E5)elements.get(4),
                (E6)elements.get(5),
                (E7)elements.get(6),
                (E8)elements.get(7),
                elements.subList(8, elements.size()));
    }
}
