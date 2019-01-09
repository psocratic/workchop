package com.psocratic.workchop.util.kit;

public interface Kit5Assembler<E1, E2, E3, E4, E5, P extends Kit5<E1, E2, E3, E4, E5>> extends KitAssembler<P> {
    P assemble(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5);
}
