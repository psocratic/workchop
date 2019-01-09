package com.psocratic.workchop.spec;

import com.psocratic.workchop.util.Numbers;
import com.psocratic.workchop.util.kit.*;
import com.psocratic.workchop.util.kit.StrictKit7;

import static com.psocratic.workchop.util.kit.StrictKits.kit;

class ExtensibleSpecImpl<I, R>
        implements ExtensibleSpec<I, R>, Spec<I, R> {
    private final Spec<I, R> innerSpec;

    ExtensibleSpecImpl(Spec<I, R> innerSpec) {
        this.innerSpec = innerSpec;
    }

    @Override
    public <R1> ExtensibleSpec<I, R1> inSeries(Spec<R, R1> nextSpec) {
        SeriesSpec<I, R, R1> seriesSpec = new SeriesSpecImpl<>(innerSpec, nextSpec);
        return new ExtensibleSpecImpl<>(seriesSpec);
    }

    @Override
    public SpecType getSpecType() {
        return innerSpec.getSpecType();
    }

    @Override
    public <E1, E2> ExtensibleSpec<I, Kit2<E1, E2>>
    inParallel(Spec<R, E1> s1, Spec<R, E2> s2) {
        Kit2Assembler<E1, E2, Kit2<E1, E2>> kitAssembler = KitAssemblers.two();
        Parallel2Spec<R, E1, E2, Kit2<E1, E2>> parallelSpec
                = new Parallel2SpecImpl<>(kitAssembler, StrictKits.kit(s1, s2));
        SeriesSpec<I, ?, Kit2<E1, E2>> nextSpec = new SeriesSpecImpl<>(innerSpec, parallelSpec);
        return new ExtensibleSpecImpl<>(nextSpec);
    }

    @Override
    public <E1, E2, E3> ExtensibleSpec<I, Kit3<E1, E2, E3>>
    inParallel(Spec<R, E1> s1, Spec<R, E2> s2, Spec<R, E3> s3) {
        Kit3Assembler<E1, E2, E3, Kit3<E1, E2, E3>> kitAssembler = KitAssemblers.three();
        ParallelSpec<R, Kit3<E1, E2, E3>> nextSpec
                = new Parallel3SpecImpl<>(kitAssembler, StrictKits.kit(s1, s2, s3));
        return inSeries(nextSpec);
    }

    @Override
    public <E1, E2, E3, E4> ExtensibleSpec<I, Kit4<E1, E2, E3, E4>>
    inParallel(Spec<R, E1> s1, Spec<R, E2> s2, Spec<R, E3> s3, Spec<R, E4> s4) {
        Kit4Assembler<E1, E2, E3, E4, Kit4<E1, E2, E3, E4>> kitAssembler = KitAssemblers.four();
        ParallelSpec<R, Kit4<E1, E2, E3, E4>> nextSpec
                = new Parallel4SpecImpl<>(kitAssembler, StrictKits.kit(s1, s2, s3, s4));
        return inSeries(nextSpec);
    }

    @Override
    public <E1, E2, E3, E4, E5> ExtensibleSpec<I, Kit5<E1, E2, E3, E4, E5>>
    inParallel(Spec<R, E1> s1, Spec<R, E2> s2, Spec<R, E3> s3, Spec<R, E4> s4,
               Spec<R, E5> s5) {
        Kit5Assembler<E1, E2, E3, E4, E5, Kit5<E1, E2, E3, E4, E5>> kitAssembler = KitAssemblers.five();
        ParallelSpec<R, Kit5<E1, E2, E3, E4, E5>> nextSpec
                = new Parallel5SpecImpl<>(kitAssembler, StrictKits.kit(s1, s2, s3, s4, s5));
        return inSeries(nextSpec);
    }

    @Override
    public <E1, E2, E3, E4, E5, E6> ExtensibleSpec<I, Kit6<E1, E2, E3, E4, E5, E6>>
    inParallel(Spec<R, E1> s1, Spec<R, E2> s2, Spec<R, E3> s3, Spec<R, E4> s4,
               Spec<R, E5> s5, Spec<R, E6> s6) {
        Kit6Assembler<E1, E2, E3, E4, E5, E6, Kit6<E1, E2, E3, E4, E5, E6>> kitAssembler = KitAssemblers.six();
        ParallelSpec<R, Kit6<E1, E2, E3, E4, E5, E6>> nextSpec
                = new Parallel6SpecImpl<>(kitAssembler, StrictKits.kit(s1, s2, s3, s4, s5, s6));
        return inSeries(nextSpec);
    }

    @Override
    public <E1, E2, E3, E4, E5, E6, E7> ExtensibleSpec<I, Kit7<E1, E2, E3, E4, E5, E6, E7>>
    inParallel(Spec<R, E1> s1, Spec<R, E2> s2, Spec<R, E3> s3, Spec<R, E4> s4,
               Spec<R, E5> s5, Spec<R, E6> s6, Spec<R, E7> s7) {
        Kit7Assembler<E1, E2, E3, E4, E5, E6, E7, Kit7<E1, E2, E3, E4, E5, E6, E7>> kitAssembler = KitAssemblers.seven();
        StrictKit7<Numbers.Seven, Spec<R, ?>, Spec<R, E1>, Spec<R, E2>, Spec<R, E3>, Spec<R, E4>,
                                      Spec<R, E5>, Spec<R, E6>, Spec<R, E7>> specs = StrictKits.kit(s1, s2, s3, s4, s5, s6, s7);
        ParallelSpec<R, Kit7<E1, E2, E3, E4, E5, E6, E7>> nextSpec
                = new Parallel7SpecImpl<>(kitAssembler, specs);
        return inSeries(nextSpec);
    }

    @Override
    public <E1, E2, E3, E4, E5, E6, E7, E8> ExtensibleSpec<I, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>>
    inParallel(Spec<R, E1> s1, Spec<R, E2> s2, Spec<R, E3> s3, Spec<R, E4> s4,
               Spec<R, E5> s5, Spec<R, E6> s6, Spec<R, E7> s7, Spec<R, E8> s8) {
        Kit8Assembler<E1, E2, E3, E4, E5, E6, E7, E8, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> kitAssembler
                = KitAssemblers.eight();
        ParallelSpec<R, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> nextSpec
                = new Parallel8SpecImpl<>(kitAssembler, kit(s1, s2, s3, s4, s5, s6, s7, s8));
        return inSeries(nextSpec);
    }

    @Override
    public CompositeSpec<I, R> toComposite() {
        return innerSpec.toComposite();
    }

    @Override
    public StepSpec<I, R> toStep() {
        return innerSpec.toStep();
    }
}
