package com.psocratic.workchop.util.kit;

import java.util.List;

public interface KitAssembler<P extends Kit> {
    P assemble(List<Object> elements);
}
