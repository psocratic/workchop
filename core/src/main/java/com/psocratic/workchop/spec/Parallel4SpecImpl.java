package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit4;
import com.psocratic.workchop.util.kit.Kit4Assembler;
import com.psocratic.workchop.util.kit.StrictKit4;

final class Parallel4SpecImpl<I, E1, E2, E3, E4> implements Parallel4Spec<I, E1, E2, E3, E4, Kit4<E1, E2, E3, E4>> {
    private final Kit4Assembler<E1, E2, E3, E4, Kit4<E1, E2, E3, E4>> kitAssembler;
    private final StrictKit4<Numbers.Four, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>> specs;

    Parallel4SpecImpl(Kit4Assembler<E1, E2, E3, E4, Kit4<E1, E2, E3, E4>> kitAssembler,
                      StrictKit4<Numbers.Four, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>> specs) {
        this.kitAssembler = kitAssembler;
        this.specs = specs;
    }

    @Override
    public StrictKit4<? extends Numbers.Four, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>> getSpecs() {
        return specs;
    }

    @Override
    public Kit4Assembler<E1, E2, E3, E4, Kit4<E1, E2, E3, E4>> getKitAssembler() {
        return kitAssembler;
    }
}
