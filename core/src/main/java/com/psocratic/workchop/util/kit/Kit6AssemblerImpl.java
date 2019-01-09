package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;

class Kit6AssemblerImpl<E1, E2, E3, E4, E5, E6> implements Kit6Assembler<E1, E2, E3, E4, E5, E6, Kit6<E1, E2, E3, E4, E5, E6>> {
    @Override
    public Kit6<E1, E2, E3, E4, E5, E6> assemble(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6) {
        return assemble(e1, e2, e3, e4, e5, e6, emptyList());
    }

    Kit6<E1, E2, E3, E4, E5, E6> assemble(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, List<Object> remainder) {
        return new Kit6Impl<>(e1, e2, e3, e4, e5, e6, remainder);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Kit6<E1, E2, E3, E4, E5, E6> assemble(List<Object> elements) {
        return assemble(
                (E1)elements.get(0),
                (E2)elements.get(1),
                (E3)elements.get(2),
                (E4)elements.get(3),
                (E5)elements.get(4),
                (E6)elements.get(5),
                elements.subList(6, elements.size()));
    }
}
