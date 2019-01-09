package com.psocratic.workchop.step;

import com.psocratic.workchop.util.kit.Kit2;

class ExtractTwoStep<E2, P extends Kit2<?, E2>> implements Step<P, E2> {
    @Override
    public E2 execute(P input) throws StepExecutionException {
        return input.two();
    }
}
