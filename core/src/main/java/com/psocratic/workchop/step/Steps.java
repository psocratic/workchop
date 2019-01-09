package com.psocratic.workchop.step;

import com.psocratic.workchop.util.kit.Kit1;
import com.psocratic.workchop.util.kit.Kit2;

/**
 * A utility class for creating steps.
 */
public final class Steps {
    private Steps() {}

    /**
     * Create a {@link StepError} from a failed {@link Step} and the {@link StepExecutionException}
     * it threw upon failure.
     *
     * @param step A step that failed to execute.
     * @param cause The cause of the step's failure.
     * @param <I> The input type of the failed step.
     * @param <R> The output type of the failed step.
     * @return A {@link StepError} enclosing the failed {@code Step}
     * and the {@link StepExecutionException} describing the cause
     * of its failure.
     */
    public static <I, R> StepError<I, R> createError(Step<I, R> step, StepExecutionException cause) {
        return new StepErrorImpl<>(step, cause);
    }

    public static <E1, P extends Kit1<E1>> Step<P, E1> extractOne() {
        return new ExtractOneStep<>();
    }

    public static <E2, P extends Kit2<?, E2>> Step<P, E2> extractTwo() {
        return new ExtractTwoStep<>();
    }

    /**
     * Create an "intake" step which passes inputs through
     * as outputs without modification.
     *
     * @param <I> The input and output type.
     * @return The "intake" step.
     */
    public static <I> Step<I, I> intake() {
        return new IntakeStep<>();
    }

}
