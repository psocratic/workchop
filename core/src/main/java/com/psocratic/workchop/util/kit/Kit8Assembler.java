package com.psocratic.workchop.util.kit;

public interface Kit8Assembler<E1, E2, E3, E4, E5, E6, E7, E8, P extends Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> extends KitAssembler<P> {
    P assemble(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7, E8 e8);
}
