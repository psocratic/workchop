package com.psocratic.workchop.line;

import com.psocratic.workchop.spec.StepSpec;
import com.psocratic.workchop.spec.StepSpecs;
import com.psocratic.workchop.util.kit.Kit2;

class MathSpecs {
    private MathSpecs() {}

    static StepSpec<Integer, Integer> add(int i) {
        return StepSpecs.create(input -> input + i);
    }

    static StepSpec<Integer, Integer> multiplyBy(int i) {
        return StepSpecs.create(input -> input * i);
    }

    static StepSpec<Integer, Integer> modulo(int i) {
        return StepSpecs.create(input -> input % i);
    }

    static StepSpec<Integer, Integer> subtract(int i) {
        return StepSpecs.create(input -> input - i);
    }

    static StepSpec<Integer, Integer> toPower(int i) {
        return toPower((double)i);
    }

    static StepSpec<Integer, Integer> toPower(double v) {
        return StepSpecs.create(input -> (int)Math.pow((double)input, v));
    }

    static StepSpec<Integer, Integer> factorial() {
        return StepSpecs.create(MathSteps.factorial());
    }

    static StepSpec<Kit2<Integer, Integer>, Integer> absoluteDifference() {
        return StepSpecs.create(input -> Math.abs(input.one() - input.two()));
    }
}
