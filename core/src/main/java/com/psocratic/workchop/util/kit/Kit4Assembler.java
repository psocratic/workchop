package com.psocratic.workchop.util.kit;

public interface Kit4Assembler<E1, E2, E3, E4, P extends Kit4<E1, E2, E3, E4>> extends KitAssembler<P> {
    P assemble(E1 e1, E2 e2, E3 e3, E4 e4);
}
