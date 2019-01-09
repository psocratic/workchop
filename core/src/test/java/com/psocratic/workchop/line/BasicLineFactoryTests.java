package com.psocratic.workchop.line;

import com.psocratic.workchop.spec.Spec;
import com.psocratic.workchop.spec.ExtensibleSpecs;
import com.psocratic.workchop.spec.StepSpec;
import com.psocratic.workchop.step.Step;
import com.psocratic.workchop.util.InstanceOrType;
import com.psocratic.workchop.util.kit.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@DisplayName("BasicLineFactory tests")
class BasicLineFactoryTests {
    private static final Step<String, String> HELLO_STEP = input -> "Hello, " + input + "!";
    private static final StepSpec<String, String> HELLO_SPEC
            = (StepSpec<String, String>) () -> InstanceOrType.instance(HELLO_STEP);

    private static final Step<String, String> GOODBYE_STEP = input -> "Goodbye, " + input + "!";
    private static final StepSpec<String, String> GOODBYE_SPEC
            = (StepSpec<String, String>) () -> InstanceOrType.instance(GOODBYE_STEP);

    private static final Step<String, String> UPPER_CASE_STEP
            = String::toUpperCase;
    private static final StepSpec<String, String> UPPER_CASE_SPEC
            = (StepSpec<String, String>) () -> InstanceOrType.instance(UPPER_CASE_STEP);

    private final Spec<String, Kit2<String, String>> HELLO_AND_GOODBYE_SPEC
            = ExtensibleSpecs.<String>intake().inParallel(HELLO_SPEC, GOODBYE_SPEC);
    private final Spec<String, String> UPPER_CASE_AND_HELLO_SPEC
            = ExtensibleSpecs.<String>intake().inSeries(UPPER_CASE_SPEC).inSeries(HELLO_SPEC);

    private LineFactory lineFactory;

    @BeforeEach
    void setUp() {
        lineFactory = new BasicLineFactory();
    }

    @Nested
    @DisplayName("When creating a line from a series spec")
    class WhenCreatingALineFromASeriesSpec {
        @Test
        @DisplayName("It generates a line that produces successful executions")
        void itGeneratesAFunctioningLine() throws LineFactoryException {
            Line<String, String> line = lineFactory.create(UPPER_CASE_AND_HELLO_SPEC);
            LineResult<String> lineResult = line.execute("world");

            assertThat(lineResult.succeeded(), is(true));
            assertThat(lineResult.getValue(), is(equalTo("Hello, WORLD!")));
        }
    }

    @Nested
    @DisplayName("When creating a line from a (two-)inParallel spec")
    class WhenCreatingALineFromATwoParallelSpec {
        private Line<String, Kit2<String, String>> line;
        private Exception lineFactoryException;

        @BeforeEach
        void setUp() {
            try {
                line = lineFactory.create(HELLO_AND_GOODBYE_SPEC);
                lineFactoryException = null;
            } catch(Exception e) {
                lineFactoryException = e;
            }
        }

        @Test
        @DisplayName("It generates a line without throwing an exception")
        void itGeneratesALine() {
            assertThat(line, is(not(nullValue())));
            assertThat(lineFactoryException, is(nullValue()));
        }

        @Nested
        @DisplayName("Executions of the line")
        class TheLineResults {
            private LineResult<Kit2<String, String>> lineResult;

            @BeforeEach
            void setUp() {
                 lineResult = line.execute("world");
            }

            @Test
            @DisplayName("Are successful")
            void areSuccessful() {
                assertThat(lineResult.succeeded(), is(true));
                assertThat(lineResult.getValue(), is(notNullValue()));
            }

            @Test
            @DisplayName("Contain two-kit results with the correct values")
            void containsATwoPartResultWithCorrectValues() {
                Kit2<String, String> value = lineResult.getValue();

                assertThat(value.one(), is(equalTo("Hello, world!")));
                assertThat(value.two(), is(equalTo("Goodbye, world!")));
            }
        }
    }

    @Nested
    @DisplayName("When creating a line from a (three-)inParallel spec")
    class WhenCreatingALineFromAThreeParallelSpec {
        private final Spec<Integer, Kit3<Integer, Integer, Integer>> THREE_SPLIT_SPEC
                    = ExtensibleSpecs.<Integer>intake().inParallel(MathSpecs.add(2), MathSpecs.multiplyBy(-1), MathSpecs.modulo(3));

        private Line<Integer, Kit3<Integer, Integer, Integer>> line;
        private Exception lineFactoryException;

        @BeforeEach
        void setUp() {
            try {
                line = lineFactory.create(THREE_SPLIT_SPEC);
                lineFactoryException = null;
            } catch(Exception e) {
                lineFactoryException = e;
            }
        }

        @Test
        @DisplayName("It generates a line without throwing an exception")
        void itGeneratesAFunctioningLine() {
            assertThat(line, is(not(nullValue())));
            assertThat(lineFactoryException, is(nullValue()));
        }

        @Nested
        @DisplayName("Executions of the line")
        class TheLineResults {
            private LineResult<Kit3<Integer, Integer, Integer>> lineResult;

            @BeforeEach
            void setUp() {
                 lineResult = line.execute(9);
            }

            @Test
            @DisplayName("Are successful")
            void areSuccessful() {
                assertThat(lineResult.succeeded(), is(true));
                assertThat(lineResult.getValue(), is(notNullValue()));
            }

            @Test
            @DisplayName("Contains a three-kit results with the correct values")
            void containsAThreePartResultWithCorrectValues() {
                Kit3<Integer, Integer, Integer> value = lineResult.getValue();

                assertThat(value.one(), is(equalTo(11)));
                assertThat(value.two(), is(equalTo(-9)));
                assertThat(value.three(), is(equalTo(0)));
            }
        }
    }

    @Nested
    @DisplayName("When creating a line from a (four-)inParallel spec")
    class WhenCreatingALineFromAFourParallelSpec {
        private final Spec<Integer, Kit4<Integer, Integer, Integer, Integer>> FOUR_SPLIT_SPEC
                    = ExtensibleSpecs.<Integer>intake().inParallel(MathSpecs.add(2), MathSpecs.multiplyBy(-1), MathSpecs.modulo(3), MathSpecs.subtract(10));

        private Line<Integer, Kit4<Integer, Integer, Integer, Integer>> line;
        private Exception lineFactoryException;

        @BeforeEach
        void setUp() {
            try {
                line = lineFactory.create(FOUR_SPLIT_SPEC);
                lineFactoryException = null;
            } catch(Exception e) {
                lineFactoryException = e;
            }
        }

        @Test
        @DisplayName("It generates a line without throwing an exception")
        void itGeneratesAFunctioningLine() {
            assertThat(line, is(not(nullValue())));
            assertThat(lineFactoryException, is(nullValue()));
        }

        @Nested
        @DisplayName("Executions of the line")
        class TheLineResults {
            private LineResult<Kit4<Integer, Integer, Integer, Integer>> lineResult;

            @BeforeEach
            void setUp() {
                 lineResult = line.execute(10);
            }

            @Test
            @DisplayName("Are successful")
            void areSuccessful() {
                assertThat(lineResult.succeeded(), is(true));
                assertThat(lineResult.getValue(), is(notNullValue()));
            }

            @Test
            @DisplayName("Contain four-kit results with the correct values")
            void containsAFourPartResultWithCorrectValues() {
                Kit4<Integer, Integer, Integer, Integer> value = lineResult.getValue();

                assertThat(value.one(), is(equalTo(12)));
                assertThat(value.two(), is(equalTo(-10)));
                assertThat(value.three(), is(equalTo(1)));
                assertThat(value.four(), is(equalTo(0)));
            }
        }
    }

    @Nested
    @DisplayName("When creating a line from a (five-)inParallel spec")
    class WhenCreatingALineFromAFiveParallelSpec {
        private final Spec<Integer, Kit5<Integer, Integer, Integer, Integer, Integer>> FIVE_SPLIT_SPEC
                    = ExtensibleSpecs.<Integer>intake()
                           .inParallel(MathSpecs.add(2), MathSpecs.multiplyBy(-1), MathSpecs.modulo(3), MathSpecs.subtract(10),
                                  MathSpecs.toPower(2));

        private Line<Integer, Kit5<Integer, Integer, Integer, Integer, Integer>> line;
        private Exception lineFactoryException;

        @BeforeEach
        void setUp() {
            try {
                line = lineFactory.create(FIVE_SPLIT_SPEC);
                lineFactoryException = null;
            } catch(Exception e) {
                lineFactoryException = e;
            }
        }

        @Test
        @DisplayName("It generates a line without throwing an exception")
        void itGeneratesAFunctioningLine() {
            assertThat(line, is(not(nullValue())));
            assertThat(lineFactoryException, is(nullValue()));
        }

        @Nested
        @DisplayName("Executions of the line")
        class TheLineResults {
            private LineResult<Kit5<Integer, Integer, Integer, Integer, Integer>> lineResult;

            @BeforeEach
            void setUp() {
                 lineResult = line.execute(11);
            }

            @Test
            @DisplayName("Are successful")
            void areSuccessful() {
                assertThat(lineResult.succeeded(), is(true));
                assertThat(lineResult.getValue(), is(notNullValue()));
            }

            @Test
            @DisplayName("Contains a five-kit results with the correct values")
            void containsAFivePartResultWithCorrectValues() {
                Kit5<Integer, Integer, Integer, Integer, Integer> value = lineResult.getValue();

                assertThat(value.one(), is(equalTo(13)));
                assertThat(value.two(), is(equalTo(-11)));
                assertThat(value.three(), is(equalTo(2)));
                assertThat(value.four(), is(equalTo(1)));
                assertThat(value.five(), is(equalTo(121)));
            }
        }
    }

    @Nested
    @DisplayName("When creating a line from a (six-)inParallel spec")
    class WhenCreatingALineFromASixParallelSpec {
        private final Spec<Integer, Kit6<Integer, Integer, Integer, Integer, Integer, Integer>> SIX_SPLIT_SPEC
                    = ExtensibleSpecs.<Integer>intake()
                            .inParallel(MathSpecs.add(2), MathSpecs.multiplyBy(-1), MathSpecs.modulo(3), MathSpecs.subtract(10),
                                   MathSpecs.toPower(2), MathSpecs.toPower(0.5));

        private Line<Integer, Kit6<Integer, Integer, Integer, Integer, Integer, Integer>> line;
        private Exception lineFactoryException;

        @BeforeEach
        void setUp() {
            try {
                line = lineFactory.create(SIX_SPLIT_SPEC);
                lineFactoryException = null;
            } catch(Exception e) {
                lineFactoryException = e;
            }
        }

        @Test
        @DisplayName("It generates a line without throwing an exception")
        void itGeneratesAFunctioningLine() {
            assertThat(line, is(not(nullValue())));
            assertThat(lineFactoryException, is(nullValue()));
        }

        @Nested
        @DisplayName("Executions of the line")
        class TheLineResults {
            private LineResult<Kit6<Integer, Integer, Integer, Integer, Integer, Integer>> lineResult;

            @BeforeEach
            void setUp() {
                 lineResult = line.execute(16);
            }

            @Test
            @DisplayName("Are successful")
            void areSuccessful() {
                assertThat(lineResult.succeeded(), is(true));
                assertThat(lineResult.getValue(), is(notNullValue()));
            }

            @Test
            @DisplayName("Contain five-kit results with the correct values")
            void containFivePartResultsWithCorrectValues() {
                Kit6<Integer, Integer, Integer, Integer, Integer, Integer> value = lineResult.getValue();

                assertThat(value.one(), is(equalTo(18)));
                assertThat(value.two(), is(equalTo(-16)));
                assertThat(value.three(), is(equalTo(1)));
                assertThat(value.four(), is(equalTo(6)));
                assertThat(value.five(), is(equalTo(256)));
                assertThat(value.six(), is(equalTo(4)));
            }
        }
    }

    @Nested
    @DisplayName("When creating a line from a (seven-)inParallel spec")
    class WhenCreatingALineFromASevenParallelSpec {
        private final Spec<Integer, Kit7<Integer, Integer, Integer, Integer, Integer, Integer, Integer>> SEVEN_SPLIT_SPEC
                    = ExtensibleSpecs.<Integer>intake()
                           .inParallel(MathSpecs.add(2), MathSpecs.multiplyBy(-1), MathSpecs.modulo(3), MathSpecs.subtract(10),
                                  MathSpecs.toPower(2), MathSpecs.toPower(0.5), MathSpecs.multiplyBy(2));

        private Line<Integer, Kit7<Integer, Integer, Integer, Integer, Integer, Integer, Integer>> line;
        private Exception lineFactoryException;

        @BeforeEach
        void setUp() {
            try {
                line = lineFactory.create(SEVEN_SPLIT_SPEC);
                lineFactoryException = null;
            } catch(Exception e) {
                lineFactoryException = e;
            }
        }

        @Test
        @DisplayName("It generates a line without throwing an exception")
        void itGeneratesAFunctioningLine() {
            assertThat(line, is(not(nullValue())));
            assertThat(lineFactoryException, is(nullValue()));
        }

        @Nested
        @DisplayName("Executions of the line")
        class TheLineResults {
            private LineResult<Kit7<Integer, Integer, Integer, Integer, Integer, Integer, Integer>> lineResult;

            @BeforeEach
            void setUp() {
                 lineResult = line.execute(4);
            }

            @Test
            @DisplayName("Are successful")
            void areSuccessful() {
                assertThat(lineResult.succeeded(), is(true));
                assertThat(lineResult.getValue(), is(notNullValue()));
            }

            @Test
            @DisplayName("Contain a seven-kit result with the correct values")
            void containASevenPartResultWithCorrectValues() {
                Kit7<Integer, Integer, Integer, Integer, Integer, Integer, Integer> value = lineResult.getValue();

                // Add 2
                assertThat(value.one(), is(equalTo(6)));
                // Multiply -1
                assertThat(value.two(), is(equalTo(-4)));
                // Modulo 3
                assertThat(value.three(), is(equalTo(1)));
                // Minus 10
                assertThat(value.four(), is(equalTo(-6)));
                // Power 2
                assertThat(value.five(), is(equalTo(16)));
                // Power 1/2
                assertThat(value.six(), is(equalTo(2)));
                // Multiply 2
                assertThat(value.seven(), is(equalTo(8)));
            }
        }
    }

    @Nested
    @DisplayName("When creating a line from a (eight-)inParallel spec")
    class WhenCreatingALineFromAnEightParallelSpec {
        private final Spec<Integer, Kit8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer>> EIGHT_SPLIT_SPEC
                    = ExtensibleSpecs.<Integer>intake()
                           .inParallel(MathSpecs.add(2), MathSpecs.multiplyBy(-1), MathSpecs.modulo(3), MathSpecs.subtract(10),
                                  MathSpecs.toPower(2), MathSpecs.toPower(0.5), MathSpecs.multiplyBy(2), MathSpecs.factorial());

        private Line<Integer, Kit8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer>> line;
        private Exception lineFactoryException;

        @BeforeEach
        void setUp() {
            try {
                line = lineFactory.create(EIGHT_SPLIT_SPEC);
                lineFactoryException = null;
            } catch(Exception e) {
                lineFactoryException = e;
            }
        }

        @Test
        @DisplayName("It generates a line without throwing an exception")
        void itGeneratesAFunctioningLine() {
            assertThat(line, is(not(nullValue())));
            assertThat(lineFactoryException, is(nullValue()));
        }

        @Nested
        @DisplayName("Executions of the line")
        class TheLineResults {
            private LineResult<Kit8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer>> lineResult;

            @BeforeEach
            void setUp() {
                 lineResult = line.execute(9);
            }

            @Test
            @DisplayName("Are successful")
            void areSuccessful() {
                assertThat(lineResult.succeeded(), is(true));
                assertThat(lineResult.getValue(), is(notNullValue()));
            }

            @Test
            @DisplayName("Contains an eight-kit results with the correct values")
            void containsAnEightPartResultWithCorrectValues() {
                Kit8<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> value = lineResult.getValue();

                // Add 2
                assertThat(value.one(), is(equalTo(11)));
                // Multiply -1
                assertThat(value.two(), is(equalTo(-9)));
                // Modulo 3
                assertThat(value.three(), is(equalTo(0)));
                // Minus 10
                assertThat(value.four(), is(equalTo(-1)));
                // Power 2
                assertThat(value.five(), is(equalTo(81)));
                // Power 1/2
                assertThat(value.six(), is(equalTo(3)));
                // Multiply 2
                assertThat(value.seven(), is(equalTo(18)));
                // Factorial
                assertThat(value.eight(), is(equalTo(362880)));
            }
        }
    }

    @Nested
    @DisplayName("When creating a line from a spec that splits and merges")
    class WhenCreatingALineFromSpecThatSplitsAndMerges {
        private final Spec<Integer, Integer> SPLIT_AND_MERGE_SPEC
                    = ExtensibleSpecs.<Integer>intake()
                        .inParallel(MathSpecs.factorial(), MathSpecs.toPower(2))
                        .inSeries(MathSpecs.absoluteDifference());

        private Line<Integer, Integer> line;
        private Exception lineFactoryException;

        @BeforeEach
        void setUp() {
            try {
                line = lineFactory.create(SPLIT_AND_MERGE_SPEC);
                lineFactoryException = null;
            } catch(Exception e) {
                lineFactoryException = e;
            }
        }

        @Test
        @DisplayName("It generates a line without throwing an exception")
        void itGeneratesAFunctioningLine() {
            assertThat(line, is(not(nullValue())));
            assertThat(lineFactoryException, is(nullValue()));
        }

        @Nested
        @DisplayName("Executions of the line")
        class TheLineResults {
            private LineResult<Integer> lineResult;

            @BeforeEach
            void setUp() {
                 lineResult = line.execute(6);
            }

            @Test
            @DisplayName("Are successful")
            void areSuccessful() {
                assertThat(lineResult.succeeded(), is(true));
                assertThat(lineResult.getValue(), is(notNullValue()));
            }

            @Test
            @DisplayName("Contains a result with the correct values")
            void containsAResultWithCorrectValue() {
                Integer value = lineResult.getValue();

                // Absolute difference of 6! and 6^2
                assertThat(value, is(equalTo(684)));
            }
        }
    }

    @Nested
    @DisplayName("When creating a line from a step spec")
    class WhenCreatingALineFromAStepSpec {
        @Test
        @DisplayName("It generates a line that produces successful executions")
        void itGeneratesAFunctioningLine() throws LineFactoryException {
            Line<String, String> line = lineFactory.create(HELLO_SPEC);
            LineResult<String> lineResult = line.execute("world");

            assertThat(lineResult.succeeded(), is(true));
            assertThat(lineResult.getValue(), is(equalTo("Hello, world!")));
        }
    }
}
