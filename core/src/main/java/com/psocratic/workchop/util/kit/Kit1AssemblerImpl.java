package com.psocratic.workchop.util.kit;

import java.util.List;

import static java.util.Collections.emptyList;

class Kit1AssemblerImpl<E1> implements Kit1Assembler<E1, Kit1<E1>> {
    @Override
    public Kit1<E1> assemble(E1 e1) {
        return assemble(e1, emptyList());
    }

    Kit1<E1> assemble(E1 e1, List<Object> remainder) {
        return new Kit1Impl<>(e1, remainder);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Kit1<E1> assemble(List<Object> elements) {
        return assemble((E1)elements.get(0), elements.subList(1, elements.size()));
    }
}
