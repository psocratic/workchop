package com.psocratic.workchop.line;

import com.psocratic.workchop.step.Step;

class MathSteps {
    private MathSteps() {}

    static Step<Integer, Integer> factorial() {
        return input -> {
            int result = 0;

            for(int i = input; i > 0; i--) {
                if(result == 0)
                    result = i;
                else
                    result *= i;
            }

            return result;
        };
    }
}
