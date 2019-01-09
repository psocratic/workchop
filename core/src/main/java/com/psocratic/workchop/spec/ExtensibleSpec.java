package com.psocratic.workchop.spec;

import com.psocratic.workchop.step.Step;
import com.psocratic.workchop.util.kit.*;

/**
 * A fluent interface for composing {@link Spec} elements.
 *
 * @param <I> The input type of the {@link Spec}.
 * @param <O> The output type of the {@link Spec}.
 */
public interface ExtensibleSpec<I, O> extends Spec<I, O> {
    /**
     * Extend this {@link Spec} with {@code nextSpec}, so that the input
     * type of the resulting {@link ExtensibleSpec} is the same as this
     * {@link Spec}, and the output type is the same as {@code nextSpec}.
     *
     * <pre>
     *       [---resulting spec------------------]
     *     I-|  I-[this spec]-O + O-[nextSpec]-O |-O
     *       [-----------------------------------]
     * </pre>
     *
     * @param nextSpec The next {@link Spec} to use to inSeries this spec.
     * @param <R> The result type of the {@code nextSpec}
     * @return A new {@link ExtensibleSpec} composed of this spec
     * and the {@code nextSpec}.
     */
    <R> ExtensibleSpec<I, R> inSeries(Spec<O, R> nextSpec);

    default <R> ExtensibleSpec<I, R> inSeries(Step<O, R> nextStep) {
        return inSeries(StepSpecs.create(nextStep));
    }

    default <R> ExtensibleSpec<I, R> inSeries(Class<Step<O, R>> nextStep) {
        return inSeries(StepSpecs.create(nextStep));
    }

    /**
     * Extend this {@link Spec} with a {@link ParallelSpec} spec composed of
     * parameters {@code s1} and {@code s2}, so that the resulting {@link ExtensibleSpec}
     * has the same input type as this {@link Spec}, with an output type
     * compounding the the output types of {@code s1} and {@code s2} ({@code E1}
     * and {@code E2}, respectively).
     *
     * <pre>
     *       [---resulting spec------------]
     *     I-| I-[this spec]-O + O-[s1]-E1 |-(E1,E2)
     *       |                 + O-[s2]-E2 |
     *       [-----------------------------]
     * </pre>
     *
     * @param s1 The first {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s2 The second {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param <E1> The first operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E2> The second operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @return A new {@link ExtensibleSpec} composed of this spec and a {@link ParallelSpec}
     *        created from parameters {@code s1} and {@code s2}.
     */
    <E1, E2> ExtensibleSpec<I, Kit2<E1, E2>> inParallel(Spec<O, E1> s1, Spec<O, E2> s2);

    default <E1, E2> ExtensibleSpec<I, Kit2<E1, E2>> inParallel(Step<O, E1> s1, Step<O, E2> s2) {
        return inParallel(StepSpecs.create(s1), StepSpecs.create(s2));
    }

    default <E1, E2> ExtensibleSpec<I, Kit2<E1, E2>> inParallel(Class<Step<O, E1>> s1, Class<Step<O, E2>> s2) {
        return inParallel(StepSpecs.create(s1), StepSpecs.create(s2));
    }

    /**
     * Extend this {@link Spec} with a {@link ParallelSpec} spec composed of
     * {@code s1} through {@code s3}, so that the resulting {@link ExtensibleSpec}
     * has the same input type as this {@link Spec}, with an output type
     * compounding the the output types of {@code s1} through {@code s3} ({@code E1}
     * through {@code E3}, respectively).
     *
     * <pre>
     *       [---resulting spec------------]
     *       |                 + O-[s1]-E1 |
     *     I-| I-[this spec]-O + O-[s2]-E2 |-(E1,E2,E3)
     *       |                 + O-[s3]-E3 |
     *       [-----------------------------]
     * </pre>
     *
     * @param s1 The first {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s2 The second {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s3 The third {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param <E1> The first operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E2> The second operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E3> The third operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @return A new {@link ExtensibleSpec} composed of this spec and a {@link ParallelSpec}
     *        created from parameters {@code s1} through {@code s3}.
     */
    <E1, E2, E3> ExtensibleSpec<I, Kit3<E1, E2, E3>> inParallel(Spec<O, E1> s1, Spec<O, E2> s2, Spec<O, E3> s3);

    default <E1, E2, E3> ExtensibleSpec<I, Kit3<E1, E2, E3>> inParallel(Step<O, E1> s1, Step<O, E2> s2, Step<O, E3> s3) {
        return inParallel(StepSpecs.create(s1), StepSpecs.create(s2), StepSpecs.create(s3));
    }

    default <E1, E2, E3> ExtensibleSpec<I, Kit3<E1, E2, E3>> inParallel(Class<Step<O, E1>> s1, Class<Step<O, E2>> s2, Class<Step<O, E3>> s3) {
        return inParallel(StepSpecs.create(s1), StepSpecs.create(s2), StepSpecs.create(s3));
    }

    /**
     * Extend this {@link Spec} with a {@link ParallelSpec} spec composed of
     * parameters {@code s1} through {@code s4}, so that the resulting {@link ExtensibleSpec}
     * has the same input type as this {@link Spec}, with an output type
     * compounding the the output types of {@code s1} through {@code s4} ({@code E1}
     * through {@code E4}, respectively).
     *
     * <pre>
     *       [---resulting spec------------]
     *       |                 + O-[s1]-E1 |
     *     I-| I-[this spec]-O + O-[s2]-E2 |-(E1,E2,E3,E4)
     *       |                 + O-[s3]-E3 |
     *       |                 + O-[s4]-E4 |
     *       [-----------------------------]
     * </pre>
     *
     * @param s1 The first {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s2 The second {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s3 The third {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s4 The fourth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param <E1> The first operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E2> The second operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E3> The third operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E4> The fourth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @return A new {@link ExtensibleSpec} composed of this spec and a {@link ParallelSpec}
     *        created from parameters {@code s1} through {@code s4}.
     */
    <E1, E2, E3, E4> ExtensibleSpec<I, Kit4<E1, E2, E3, E4>> inParallel(Spec<O, E1> s1, Spec<O, E2> s2, Spec<O, E3> s3, Spec<O, E4> s4);

    default <E1, E2, E3, E4> ExtensibleSpec<I, Kit4<E1, E2, E3, E4>> inParallel(Step<O, E1> s1, Step<O, E2> s2, Step<O, E3> s3, Step<O, E4> s4) {
        return inParallel(StepSpecs.create(s1), StepSpecs.create(s2), StepSpecs.create(s3), StepSpecs.create(s4));
    }

    default <E1, E2, E3, E4> ExtensibleSpec<I, Kit4<E1, E2, E3, E4>> inParallel(Class<Step<O, E1>> s1, Class<Step<O, E2>> s2, Class<Step<O, E3>> s3, Class<Step<O, E4>> s4) {
        return inParallel(StepSpecs.create(s1), StepSpecs.create(s2), StepSpecs.create(s3), StepSpecs.create(s4));
    }

    /**
     * Extend this {@link Spec} with a {@link ParallelSpec} spec composed of
     * parameters {@code s1} through {@code s5}, so that the resulting {@link ExtensibleSpec}
     * has the same input type as this {@link Spec}, with an output type
     * compounding the the output types of {@code s1} through {@code s5} ({@code E1}
     * through {@code E5}, respectively).
     *
     * <pre>
     *       [---resulting spec------------]
     *       |                 + O-[s1]-E1 |
     *       |                 + O-[s2]-E2 |
     *     I-| I-[this spec]-O + O-[s3]-E3 |-(E1,E2,E3,E4,E5)
     *       |                 + O-[s4]-E4 |
     *       |                 + O-[s5]-E5 |
     *       [-----------------------------]
     * </pre>
     *
     * @param s1 The first {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s2 The second {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s3 The third {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s4 The fourth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s5 The fifth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param <E1> The first operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E2> The second operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E3> The third operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E4> The fourth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E5> The fifth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @return A new {@link ExtensibleSpec} composed of this spec and a {@link ParallelSpec}
     *        created from parameters {@code s1} through {@code s5}.
     */
    <E1, E2, E3, E4, E5> ExtensibleSpec<I, Kit5<E1, E2, E3, E4, E5>> inParallel(Spec<O, E1> s1, Spec<O, E2> s2, Spec<O, E3> s3, Spec<O, E4> s4, Spec<O, E5> s5);

    default <E1, E2, E3, E4, E5> ExtensibleSpec<I, Kit5<E1, E2, E3, E4, E5>> inParallel(Step<O, E1> s1, Step<O, E2> s2, Step<O, E3> s3, Step<O, E4> s4, Step<O, E5> s5) {
        return inParallel(StepSpecs.create(s1), StepSpecs.create(s2), StepSpecs.create(s3), StepSpecs.create(s4), StepSpecs.create(s5));
    }

    default <E1, E2, E3, E4, E5> ExtensibleSpec<I, Kit5<E1, E2, E3, E4, E5>> inParallel(Class<Step<O, E1>> s1, Class<Step<O, E2>> s2, Class<Step<O, E3>> s3, Class<Step<O, E4>> s4,
                                                                                        Class<Step<O, E5>> s5) {
        return inParallel(StepSpecs.create(s1), StepSpecs.create(s2), StepSpecs.create(s3), StepSpecs.create(s4), StepSpecs.create(s5));
    }

    /**
     * Extend this {@link Spec} with a {@link ParallelSpec} spec composed of
     * parameters {@code s1} through {@code s6}, so that the resulting {@link ExtensibleSpec}
     * has the same input type as this {@link Spec}, with an output type
     * compounding the the output types of {@code s1} through {@code s6} ({@code E1}
     * through {@code E6}, respectively).
     *
     * <pre>
     *       [---resulting spec------------]
     *       |                 + O-[s1]-E1 |
     *       |                 + O-[s2]-E2 |
     *     I-| I-[this spec]-O + O-[s3]-E3 |-(E1,E2,E3,E4,E5,E6)
     *       |                 + O-[s4]-E4 |
     *       |                 + O-[s5]-E5 |
     *       |                 + O-[s6]-E6 |
     *       [-----------------------------]
     * </pre>
     *
     * @param s1 The first {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s2 The second {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s3 The third {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s4 The fourth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s5 The fifth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s6 The sixth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param <E1> The first operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E2> The second operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E3> The third operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E4> The fourth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E5> The fifth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E6> The sixth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @return A new {@link ExtensibleSpec} composed of this spec and a {@link ParallelSpec}
     *        created from parameters {@code s1} through {@code s6}.
     */
    <E1, E2, E3, E4, E5, E6> ExtensibleSpec<I, Kit6<E1, E2, E3, E4, E5, E6>> inParallel(Spec<O, E1> s1, Spec<O, E2> s2, Spec<O, E3> s3, Spec<O, E4> s4, Spec<O, E5> s5, Spec<O, E6> s6);

    default <E1, E2, E3, E4, E5, E6> ExtensibleSpec<I, Kit6<E1, E2, E3, E4, E5, E6>> inParallel(Step<O, E1> s1, Step<O, E2> s2, Step<O, E3> s3, Step<O, E4> s4,
                                                                                                Step<O, E5> s5, Step<O, E6> s6) {
        return inParallel(StepSpecs.create(s1), StepSpecs.create(s2), StepSpecs.create(s3), StepSpecs.create(s4),
                     StepSpecs.create(s5), StepSpecs.create(s6));
    }

    default <E1, E2, E3, E4, E5, E6> ExtensibleSpec<I, Kit6<E1, E2, E3, E4, E5, E6>> inParallel(Class<Step<O, E1>> s1, Class<Step<O, E2>> s2, Class<Step<O, E3>> s3, Class<Step<O, E4>> s4,
                                                                                                Class<Step<O, E5>> s5, Class<Step<O, E6>> s6) {
        return inParallel(StepSpecs.create(s1), StepSpecs.create(s2), StepSpecs.create(s3), StepSpecs.create(s4),
                     StepSpecs.create(s5), StepSpecs.create(s6));
    }

    /**
     * Extend this {@link Spec} with a {@link ParallelSpec} spec composed of
     * parameters {@code s1} through {@code s7}, so that the resulting {@link ExtensibleSpec}
     * has the same input type as this {@link Spec}, with an output type
     * compounding the the output types of {@code s1} through {@code s6} ({@code E1}
     * through {@code E7}, respectively).
     *
     * <pre>
     *       [---resulting spec------------]
     *       |                 + O-[s1]-E1 |
     *       |                 + O-[s2]-E2 |
     *       |                 + O-[s2]-E3 |
     *     I-| I-[this spec]-O + O-[s3]-E4 |-(E1,E2,E3,E4,E5,E6,E7)
     *       |                 + O-[s4]-E5 |
     *       |                 + O-[s5]-E6 |
     *       |                 + O-[s6]-E7 |
     *       [-----------------------------]
     * </pre>

     * @param s1 The first {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s2 The second {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s3 The third {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s4 The fourth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s5 The fifth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s6 The sixth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s7 The seventh {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param <E1> The first operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E2> The second operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E3> The third operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E4> The fourth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E5> The fifth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E6> The sixth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E7> The seventh operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @return A new {@link ExtensibleSpec} composed of this spec and a {@link ParallelSpec}
     *        created from parameters {@code s1} through {@code s7}.
     */
    <E1, E2, E3, E4, E5, E6, E7> ExtensibleSpec<I, Kit7<E1, E2, E3, E4, E5, E6, E7>> inParallel(Spec<O, E1> s1, Spec<O, E2> s2, Spec<O, E3> s3, Spec<O, E4> s4, Spec<O, E5> s5, Spec<O, E6> s6, Spec<O, E7> s7);

    default <E1, E2, E3, E4, E5, E6, E7> ExtensibleSpec<I, Kit7<E1, E2, E3, E4, E5, E6, E7>> inParallel(Step<O, E1> s1, Step<O, E2> s2, Step<O, E3> s3, Step<O, E4> s4,
                                                                                                        Step<O, E5> s5, Step<O, E6> s6, Step<O, E7> s7) {
        return inParallel(StepSpecs.create(s1), StepSpecs.create(s2), StepSpecs.create(s3), StepSpecs.create(s4),
                     StepSpecs.create(s5), StepSpecs.create(s6), StepSpecs.create(s7));
    }

    default <E1, E2, E3, E4, E5, E6, E7> ExtensibleSpec<I, Kit7<E1, E2, E3, E4, E5, E6, E7>> inParallel(Class<Step<O, E1>> s1, Class<Step<O, E2>> s2, Class<Step<O, E3>> s3, Class<Step<O, E4>> s4,
                                                                                                        Class<Step<O, E5>> s5, Class<Step<O, E6>> s6, Class<Step<O, E7>> s7) {
        return inParallel(StepSpecs.create(s1), StepSpecs.create(s2), StepSpecs.create(s3), StepSpecs.create(s4),
                     StepSpecs.create(s5), StepSpecs.create(s6), StepSpecs.create(s7));
    }

    /**
     * Extend this {@link Spec} with a {@link ParallelSpec} spec composed of
     * parameters {@code s1} through {@code s8}, so that the resulting {@link ExtensibleSpec}
     * has the same input type as this {@link Spec}, with an output type
     * compounding the the output types of {@code s1} through {@code s8} ({@code E1}
     * through {@code E8}, respectively).
     *
     * <pre>
     *       [---resulting spec------------]
     *       |                 + O-[s1]-E1 |
     *       |                 + O-[s2]-E2 |
     *       |                 + O-[s2]-E3 |
     *     I-| I-[this spec]-O + O-[s3]-E4 |-(E1,E2,E3,E4,E5,E6,E7,E8)
     *       |                 + O-[s4]-E5 |
     *       |                 + O-[s5]-E6 |
     *       |                 + O-[s6]-E7 |
     *       |                 + O-[s6]-E8 |
     *       [-----------------------------]
     * </pre>
     *
     * @param s1 The first {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s2 The second {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s3 The third {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s4 The fourth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s5 The fifth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s6 The sixth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s7 The seventh {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param s8 The eighth {@link Spec} component in the {@link ParallelSpec}
     *           used to inSeries this {@link Spec}.
     * @param <E1> The first operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E2> The second operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E3> The third operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E4> The fourth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E5> The fifth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E6> The sixth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E7> The seventh operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @param <E8> The eighth operand in the output type of the resulting
     *            {@link ExtensibleSpec}.
     * @return A new {@link ExtensibleSpec} composed of this spec and a {@link ParallelSpec}
     *        created from parameters {@code s1} through {@code s8}.
     */
    <E1, E2, E3, E4, E5, E6, E7, E8> ExtensibleSpec<I, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> inParallel(Spec<O, E1> s1, Spec<O, E2> s2, Spec<O, E3> s3, Spec<O, E4> s4, Spec<O, E5> s5, Spec<O, E6> s6, Spec<O, E7> s7, Spec<O, E8> s8);

    default <E1, E2, E3, E4, E5, E6, E7, E8> ExtensibleSpec<I, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> inParallel(Step<O, E1> s1, Step<O, E2> s2, Step<O, E3> s3, Step<O, E4> s4,
                                                                                                                Step<O, E5> s5, Step<O, E6> s6, Step<O, E7> s7, Step<O, E8> s8) {
         return inParallel(StepSpecs.create(s1), StepSpecs.create(s2), StepSpecs.create(s3), StepSpecs.create(s4),
                      StepSpecs.create(s5), StepSpecs.create(s6), StepSpecs.create(s7), StepSpecs.create(s8));
    }

    default <E1, E2, E3, E4, E5, E6, E7, E8> ExtensibleSpec<I, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> inParallel(Class<Step<O, E1>> s1, Class<Step<O, E2>> s2, Class<Step<O, E3>> s3, Class<Step<O, E4>> s4,
                                                                                                                Class<Step<O, E5>> s5, Class<Step<O, E6>> s6, Class<Step<O, E7>> s7, Class<Step<O, E8>> s8) {
         return inParallel(StepSpecs.create(s1), StepSpecs.create(s2), StepSpecs.create(s3), StepSpecs.create(s4),
                      StepSpecs.create(s5), StepSpecs.create(s6), StepSpecs.create(s7), StepSpecs.create(s8));
    }
}
