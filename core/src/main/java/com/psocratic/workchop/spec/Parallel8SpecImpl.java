package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit8;
import com.psocratic.workchop.util.kit.Kit8Assembler;
import com.psocratic.workchop.util.kit.StrictKit8;

final class Parallel8SpecImpl<I, E1, E2, E3, E4, E5, E6, E7, E8>
        implements Parallel8Spec<I, E1, E2, E3, E4, E5, E6, E7, E8, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> {
    private final Kit8Assembler<E1, E2, E3, E4, E5, E6, E7, E8, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> kitAssembler;
    private final StrictKit8<Numbers.Eight, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                        Spec<I, E5>, Spec<I, E6>, Spec<I, E7>, Spec<I, E8>> specs;

    Parallel8SpecImpl(Kit8Assembler<E1, E2, E3, E4, E5, E6, E7, E8, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> kitAssembler,
                      StrictKit8<Numbers.Eight, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                                              Spec<I, E5>, Spec<I, E6>, Spec<I, E7>, Spec<I, E8>> specs) {
        this.kitAssembler = kitAssembler;
        this.specs = specs;
    }

    @Override
    public StrictKit8<? extends Numbers.Eight, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                           Spec<I, E5>, Spec<I, E6>, Spec<I, E7>, Spec<I, E8>> getSpecs() {
        return specs;
    }

    @Override
    public Kit8Assembler<E1, E2, E3, E4, E5, E6, E7, E8, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> getKitAssembler() {
        return kitAssembler;
    }
}
