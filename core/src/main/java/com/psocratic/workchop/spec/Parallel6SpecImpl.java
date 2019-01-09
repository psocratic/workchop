package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.Kit6;
import com.psocratic.workchop.util.kit.Kit6Assembler;
import com.psocratic.workchop.util.kit.StrictKit6;

final class Parallel6SpecImpl<I, E1, E2, E3, E4, E5, E6>
        implements Parallel6Spec<I, E1, E2, E3, E4, E5, E6, Kit6<E1, E2, E3, E4, E5, E6>> {
    private final Kit6Assembler<E1, E2, E3, E4, E5, E6, Kit6<E1, E2, E3, E4, E5, E6>> kitAssembler;
    private final StrictKit6<Numbers.Six, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                           Spec<I, E5>, Spec<I, E6>> specs;

    Parallel6SpecImpl(Kit6Assembler<E1, E2, E3, E4, E5, E6, Kit6<E1, E2, E3, E4, E5, E6>> kitAssembler,
                      StrictKit6<Numbers.Six, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                                            Spec<I, E5>, Spec<I, E6>> specs) {
        this.kitAssembler = kitAssembler;
        this.specs = specs;
    }

    @Override
    public StrictKit6<? extends Numbers.Six, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                                         Spec<I, E5>, Spec<I, E6>> getSpecs() {
        return specs;
    }

    @Override
    public Kit6Assembler<E1, E2, E3, E4, E5, E6, Kit6<E1, E2, E3, E4, E5, E6>> getKitAssembler() {
        return kitAssembler;
    }
}
