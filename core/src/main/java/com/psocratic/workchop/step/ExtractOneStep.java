package com.psocratic.workchop.step;

import com.psocratic.workchop.util.kit.Kit1;

class ExtractOneStep<E1, P extends Kit1<E1>> implements Step<P, E1> {
    @Override
    public E1 execute(P input) throws StepExecutionException {
        return input.one();
    }
}
