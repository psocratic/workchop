package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit2;
import com.psocratic.workchop.util.kit.Kit2Assembler;
import com.psocratic.workchop.util.kit.StrictKit2;

final class Parallel2SpecImpl<I, E1, E2> implements Parallel2Spec<I, E1, E2, Kit2<E1, E2>>  {
    private final Kit2Assembler<E1, E2, Kit2<E1,E2>> partFactory;
    private final StrictKit2<? extends Numbers.Two, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>> specs;

    Parallel2SpecImpl(Kit2Assembler<E1, E2, Kit2<E1, E2>> partFactory,
                      StrictKit2<? extends Numbers.Two, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>> specs) {
        this.partFactory = partFactory;
        this.specs = specs;
    }

    @Override
    public Kit2Assembler<E1, E2, Kit2<E1, E2>> getKitAssembler() {
        return partFactory;
    }

    @Override
    public StrictKit2<? extends Numbers.Two, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>> getSpecs() {
        return specs;
    }
}
