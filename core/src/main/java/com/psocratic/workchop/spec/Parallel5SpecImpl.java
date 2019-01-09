package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit5;
import com.psocratic.workchop.util.kit.Kit5Assembler;
import com.psocratic.workchop.util.kit.StrictKit5;

final class Parallel5SpecImpl<I, E1, E2, E3, E4, E5> implements Parallel5Spec<I, E1, E2, E3, E4, E5, Kit5<E1, E2, E3, E4, E5>> {
    private final Kit5Assembler<E1, E2, E3, E4, E5, Kit5<E1, E2, E3, E4, E5>> kitAssembler;
    private final StrictKit5<Numbers.Five, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                           Spec<I, E5>> specs;

    Parallel5SpecImpl(Kit5Assembler<E1, E2, E3, E4, E5, Kit5<E1, E2, E3, E4, E5>> kitAssembler,
                      StrictKit5<Numbers.Five, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                                             Spec<I, E5>> specs) {
        this.kitAssembler = kitAssembler;
        this.specs = specs;
    }

    @Override
    public StrictKit5<? extends Numbers.Five, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                              Spec<I, E5>> getSpecs() {
        return specs;
    }

    @Override
    public Kit5Assembler<E1, E2, E3, E4, E5, Kit5<E1, E2, E3, E4, E5>> getKitAssembler() {
        return kitAssembler;
    }
}
