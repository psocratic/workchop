package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit7;
import com.psocratic.workchop.util.kit.Kit7Assembler;
import com.psocratic.workchop.util.kit.StrictKit7;

final class Parallel7SpecImpl<I, E1, E2, E3, E4, E5, E6, E7>
        implements Parallel7Spec<I, E1, E2, E3, E4, E5, E6, E7, Kit7<E1, E2, E3, E4, E5, E6, E7>> {
    private final Kit7Assembler<E1, E2, E3, E4, E5, E6, E7, Kit7<E1, E2, E3, E4, E5, E6, E7>> kitAssembler;
    private final StrictKit7<Numbers.Seven, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                        Spec<I, E5>, Spec<I, E6>, Spec<I, E7>> specs;

    Parallel7SpecImpl(Kit7Assembler<E1, E2, E3, E4, E5, E6, E7, Kit7<E1, E2, E3, E4, E5, E6, E7>> kitAssembler,
                      StrictKit7<Numbers.Seven, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                                              Spec<I, E5>, Spec<I, E6>, Spec<I, E7>> specs) {
        this.kitAssembler = kitAssembler;
        this.specs = specs;
    }

    @Override
    public StrictKit7<? extends Numbers.Seven, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                           Spec<I, E5>, Spec<I, E6>, Spec<I, E7>> getSpecs() {
        return specs;
    }

    @Override
    public Kit7Assembler<E1, E2, E3, E4, E5, E6, E7, Kit7<E1, E2, E3, E4, E5, E6, E7>> getKitAssembler() {
        return kitAssembler;
    }
}
