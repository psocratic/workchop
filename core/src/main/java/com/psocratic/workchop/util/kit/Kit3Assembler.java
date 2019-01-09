package com.psocratic.workchop.util.kit;

public interface Kit3Assembler<E1, E2, E3, P extends Kit3<E1, E2, E3>> extends KitAssembler<P> {
    P assemble(E1 e1, E2 e2, E3 e3);
}
