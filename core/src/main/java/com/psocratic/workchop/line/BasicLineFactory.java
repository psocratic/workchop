package com.psocratic.workchop.line;

import com.psocratic.workchop.spec.*;
import com.psocratic.workchop.step.Step;
import com.psocratic.workchop.step.StepInstantiationException;
import com.psocratic.workchop.step.StepInstantiator;
import com.psocratic.workchop.step.StepInstantiators;
import com.psocratic.workchop.util.InstanceOrType;
import com.psocratic.workchop.util.kit.*;

import static com.psocratic.workchop.util.kit.StrictKits.kit;

final class BasicLineFactory implements LineFactory {
    static final LineFactory INSTANCE = new BasicLineFactory();

    private final StepInstantiator stepInstantiator;

    BasicLineFactory() {
        this(StepInstantiators.byDefaultConstructor());
    }

    BasicLineFactory(StepInstantiator stepInstantiator) {
        this.stepInstantiator = stepInstantiator;
    }

    public <I, R> Line<I, R> create(Spec<I, R> spec) throws LineFactoryException {
        if(spec == null)
            throw new LineFactoryException("The provided spec may not be null");

        if(spec.getSpecType() == null)
            throw new LineFactoryException("The provided spec does not specify a spec type");

        switch(spec.getSpecType()) {
            case COMPOSITE:
                return createComposite(spec.toComposite());
            case STEP:
                return createStep(spec.toStep());
        }

        throw new LineFactoryException("Unsupported spec of type: " + spec.getClass().getCanonicalName());
    }

    private <I, R> Line<I, R> createComposite(CompositeSpec<I, R> compositeSpec) throws LineFactoryException {
        if(compositeSpec.getCompositionMode() == null)
            throw new LineFactoryException("The provided spec does not specify a composition mode");

        switch(compositeSpec.getCompositionMode()) {
            case PARALLEL:
                return createParallel(compositeSpec.toParallel());
            case SERIES:
                return createSeries(compositeSpec.toSeries());
        }

        throw new LineFactoryException("Unsupported composite spec:" + compositeSpec.getClass().getCanonicalName());
    }

    private <I, R> Line<I, R> createParallel(ParallelSpec<I, ? extends R> spec) throws LineFactoryException {
        switch(spec.getParallelism()) {
            case TWO:
                return createParallel2(spec.toParallel2());
            case THREE:
                return createParallel3(spec.toParallel3());
            case FOUR:
                return createParallel4(spec.toParallel4());
            case FIVE:
                return createParallel5(spec.toParallel5());
            case SIX:
                return createParallel6(spec.toParallel6());
            case SEVEN:
                return createParallel7(spec.toParallel7());
            case EIGHT:
                return createParallel8(spec.toParallel8());
        }

        throw new LineFactoryException("Unsupported degree of parallelism in parallel spec: " + spec.getParallelism());
    }


    private <I, E1, E2, R> Line<I, R> createParallel2(Parallel2Spec<I, E1, E2, ? extends R> spec) throws LineFactoryException {
        StrictKit2<?, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>> specs = spec.getSpecs();
        StrictKit2<?, Line<I, ?>, Line<I, E1>, Line<I, E2>> lines = StrictKits.kit(create(specs.one()), create(specs.two()));
        Line<I, ? extends R> parallelLine = new Parallel2Line<>(lines, spec.getKitAssembler());
        return new WildcardDowncastingLine<>(parallelLine);
    }

    private <I, E1, E2, E3, R> Line<I, R> createParallel3(Parallel3Spec<I, E1, E2, E3, ? extends R> spec) throws LineFactoryException {
        StrictKit3<?, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>> specs = spec.getSpecs();
        StrictKit3<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>> lines
                = StrictKits.kit(create(specs.one()), create(specs.two()), create(specs.three()));
        Line<I, ? extends R> parallelLine = new Parallel3Line<>(lines, spec.getKitAssembler());
        return new WildcardDowncastingLine<>(parallelLine);
    }

    private <I, E1, E2, E3, E4, R> Line<I, R> createParallel4(Parallel4Spec<I, E1, E2, E3, E4, ? extends R> spec) throws LineFactoryException {
        StrictKit4<?, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>> specs = spec.getSpecs();
        StrictKit4<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>> lines
                = StrictKits.kit(create(specs.one()), create(specs.two()), create(specs.three()), create(specs.four()));
        Line<I, ? extends R> parallelLine = new Parallel4Line<>(lines, spec.getKitAssembler());
        return new WildcardDowncastingLine<>(parallelLine);
    }

    private <I, E1, E2, E3, E4, E5, R> Line<I, R> createParallel5(Parallel5Spec<I, E1, E2, E3, E4, E5, ? extends R> spec) throws LineFactoryException {
        StrictKit5<?, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                              Spec<I, E5>> specs = spec.getSpecs();
        StrictKit5<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>,
                                              Line<I, E5>> lines
                = StrictKits.kit(create(specs.one()), create(specs.two()), create(specs.three()), create(specs.four()),
                        create(specs.five()));
        Line<I, ? extends R> parallelLine = new Parallel5Line<>(lines, spec.getKitAssembler());
        return new WildcardDowncastingLine<>(parallelLine);
    }

    private <I, E1, E2, E3, E4, E5, E6, R> Line<I, R> createParallel6(Parallel6Spec<I, E1, E2, E3, E4, E5, E6, ? extends R> spec) throws LineFactoryException {
        StrictKit6<?, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                              Spec<I, E5>, Spec<I, E6>> specs = spec.getSpecs();
        StrictKit6<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>,
                                      Line<I, E5>, Line<I, E6>> lines
                = StrictKits.kit(create(specs.one()), create(specs.two()), create(specs.three()), create(specs.four()),
                        create(specs.five()), create(specs.six()));
        Line<I, ? extends R> parallelLine = new Parallel6Line<>(lines, spec.getKitAssembler());
        return new WildcardDowncastingLine<>(parallelLine);
    }

    private <I, E1, E2, E3, E4, E5, E6, E7, R> Line<I, R> createParallel7(Parallel7Spec<I, E1, E2, E3, E4, E5, E6, E7, ? extends R> spec) throws LineFactoryException {
        StrictKit7<?, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                      Spec<I, E5>, Spec<I, E6>, Spec<I, E7>> specs = spec.getSpecs();
        StrictKit7<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>,
                                      Line<I, E5>, Line<I, E6>, Line<I, E7>> lines
                = StrictKits.kit(create(specs.one()), create(specs.two()), create(specs.three()), create(specs.four()),
                        create(specs.five()), create(specs.six()), create(specs.seven()));
        Line<I, ? extends R> parallelLine = new Parallel7Line<>(lines, spec.getKitAssembler());
        return new WildcardDowncastingLine<>(parallelLine);
    }

    private <I, E1, E2, E3, E4, E5, E6, E7, E8, R> Line<I, R> createParallel8(Parallel8Spec<I, E1, E2, E3, E4, E5, E6, E7, E8, ? extends R> spec) throws LineFactoryException {
        StrictKit8<?, Spec<I, ?>, Spec<I, E1>, Spec<I, E2>, Spec<I, E3>, Spec<I, E4>,
                                      Spec<I, E5>, Spec<I, E6>, Spec<I, E7>, Spec<I, E8>> specs = spec.getSpecs();
        StrictKit8<?, Line<I, ?>, Line<I, E1>, Line<I, E2>, Line<I, E3>, Line<I, E4>,
                                      Line<I, E5>, Line<I, E6>, Line<I, E7>, Line<I, E8>> lines
                = kit(create(specs.one()), create(specs.two()), create(specs.three()), create(specs.four()),
                        create(specs.five()), create(specs.six()), create(specs.seven()), create(specs.eight()));
        Line<I, ? extends R> parallelLine = new Parallel8Line<>(lines, spec.getKitAssembler());
        return new WildcardDowncastingLine<>(parallelLine);
    }

    private <I, O, R> Line<I, R> createSeries(SeriesSpec<I, O, R> seriesSpec) throws LineFactoryException {
        Line<I, O> headLine = create(seriesSpec.getHeadSpec());
        Line<O, R> tailLine = create(seriesSpec.getTailSpec());
        return new SeriesLine<>(headLine, tailLine);
    }

    private <I, R> Line<I, R> createStep(StepSpec<I, R> stepSpec) throws LineFactoryException {
        InstanceOrType<Step<I, R>> instanceOrType = stepSpec.getStep();

        Step<I, R> step;

        if(instanceOrType.isInstance()) {
            step = instanceOrType.getInstance().get();
        } else {
            Class<Step<I, R>> stepCls = instanceOrType.getType().get();

            try {
                step = stepInstantiator.instantiate(stepCls);
            } catch(final StepInstantiationException e) {
                throw new LineFactoryException("Failed to instantiate step", e);
            }
        }

        return new StepLine<>(step);
    }
}
