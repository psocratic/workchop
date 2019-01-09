package com.psocratic.workchop.util.kit;

public interface Kit2Assembler<E1, E2, P extends Kit2<E1, E2>> extends KitAssembler<P> {
    P assemble(E1 e1, E2 e2);
}
