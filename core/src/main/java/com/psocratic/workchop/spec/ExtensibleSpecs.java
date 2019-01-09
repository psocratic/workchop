package com.psocratic.workchop.spec;

import com.psocratic.workchop.step.Step;
import com.psocratic.workchop.util.kit.*;

/**
 * A utility class for creating instances of {@link ExtensibleSpec}.
 */
public final class ExtensibleSpecs {
    private ExtensibleSpecs() {}

    public static <I, E1, E2> Spec<I, Kit2<E1, E2>> combineWith(Spec<I, E1> s1, Spec<E1, E2> s2) {
        return null;
    }

    /**
     * Creates an "intake" {@link ExtensibleSpec} of type {@code I}.
     * "Intake" steps pass inputs through as outputs without
     * modifications.
     *
     * @param <I> The input and output type of the resulting {@link ExtensibleSpec}.
     * @return A new {@link ExtensibleSpec} that specifies an
     * intake {@link Step}.
     */
    public static <I> ExtensibleSpec<I, I> intake() {
        return new ExtensibleSpecImpl<>(new IntakeSpec<>());
    }

    public static <I, E1, E2> ExtensibleSpec<I, Kit2<E1, E2>> inParallel(
            Spec<I, E1> s1,
            Spec<I, E2> s2
    ) {
        return ExtensibleSpecs.<I>intake().inParallel(s1, s2);
    }

    public static <I, E1, E2, E3> ExtensibleSpec<I, Kit3<E1, E2, E3>> inParallel(
            Spec<I, E1> s1,
            Spec<I, E2> s2,
            Spec<I, E3> s3
    ) {
        return ExtensibleSpecs.<I>intake().inParallel(s1, s2, s3);
    }

    public static <I, E1, E2, E3, E4> ExtensibleSpec<I, Kit4<E1, E2, E3, E4>> inParallel(
            Spec<I, E1> s1,
            Spec<I, E2> s2,
            Spec<I, E3> s3,
            Spec<I, E4> s4
    ) {
        return ExtensibleSpecs.<I>intake().inParallel(s1, s2, s3, s4);
    }

    public static <I, E1, E2, E3, E4, E5> ExtensibleSpec<I, Kit5<E1, E2, E3, E4, E5>> inParallel(
            Spec<I, E1> s1,
            Spec<I, E2> s2,
            Spec<I, E3> s3,
            Spec<I, E4> s4,
            Spec<I, E5> s5
    ) {
        return ExtensibleSpecs.<I>intake().inParallel(s1, s2, s3, s4, s5);
    }

    public static <I, E1, E2, E3, E4, E5, E6> ExtensibleSpec<I, Kit6<E1, E2, E3, E4, E5, E6>> inParallel(
            Spec<I, E1> s1,
            Spec<I, E2> s2,
            Spec<I, E3> s3,
            Spec<I, E4> s4,
            Spec<I, E5> s5,
            Spec<I, E6> s6
    ) {
        return ExtensibleSpecs.<I>intake().inParallel(s1, s2, s3, s4, s5, s6);
    }

    public static <I, E1, E2, E3, E4, E5, E6, E7> ExtensibleSpec<I, Kit7<E1, E2, E3, E4, E5, E6, E7>> inParallel(
            Spec<I, E1> s1,
            Spec<I, E2> s2,
            Spec<I, E3> s3,
            Spec<I, E4> s4,
            Spec<I, E5> s5,
            Spec<I, E6> s6,
            Spec<I, E7> s7
    ) {
        return ExtensibleSpecs.<I>intake().inParallel(s1, s2, s3, s4, s5, s6, s7);
    }

    public static <I, E1, E2, E3, E4, E5, E6, E7, E8> ExtensibleSpec<I, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> inParallel(
            Spec<I, E1> s1,
            Spec<I, E2> s2,
            Spec<I, E3> s3,
            Spec<I, E4> s4,
            Spec<I, E5> s5,
            Spec<I, E6> s6,
            Spec<I, E7> s7,
            Spec<I, E8> s8
    ) {
        return ExtensibleSpecs.<I>intake().inParallel(s1, s2, s3, s4, s5, s6, s7, s8);
    }

    public static <I, E1, E2> Spec<I, E2> inSequence(Spec<I, E1> s1, Spec<E1, E2> s2) {
        return new SeriesSpecImpl<>(s1, s2);
    }
}
