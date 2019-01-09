package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit3;
import com.psocratic.workchop.util.kit.Kit3Assembler;
import com.psocratic.workchop.util.kit.StrictKit3;

final class Parallel3SpecImpl<I, E1, E2, E3> implements Parallel3Spec<I, E1, E2, E3, Kit3<E1, E2, E3>> {
    private final Kit3Assembler<E1, E2, E3, Kit3<E1, E2, E3>> kitAssembler;
    private final StrictKit3<Numbers.Three, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>> specs;

    Parallel3SpecImpl(Kit3Assembler<E1, E2, E3, Kit3<E1, E2, E3>> kitAssembler,
                             StrictKit3<Numbers.Three, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>> specs) {
        this.kitAssembler = kitAssembler;
        this.specs = specs;
    }

    @Override
    public StrictKit3<? extends Numbers.Three, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>> getSpecs() {
        return specs;
    }

    @Override
    public Kit3Assembler<E1, E2, E3, Kit3<E1, E2, E3>> getKitAssembler() {
        return kitAssembler;
    }
}
