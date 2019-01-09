package com.psocratic.workchop.util.kit;

public interface Kit1Assembler<E1, P extends Kit1<E1>> extends KitAssembler<P> {
    P assemble(E1 e1);
}
