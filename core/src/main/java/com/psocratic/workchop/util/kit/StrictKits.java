package com.psocratic.workchop.util.kit;

import com.psocratic.workchop.util.Numbers;

public final class StrictKits {
    private StrictKits() {}

    public static <E, E1 extends E> StrictKit1<Numbers.One, E, E1> kit(E1 e1) {
        return new StrictKit1Impl<>(Numbers.ONE, e1);
    }

    public static <E, E1 extends E, E2 extends E>
    StrictKit2<Numbers.Two, E, E1, E2>
    kit(E1 e1, E2 e2) {
        return new StrictKit2Impl<>(Numbers.TWO, e1, e2);
    }

    public static <E, E1 extends E, E2 extends E, E3 extends E>
    StrictKit3<Numbers.Three, E, E1, E2, E3>
    kit(E1 e1, E2 e2, E3 e3) {
        return new StrictKit3Impl<>(Numbers.THREE, e1, e2, e3);
    }

    public static <E, E1 extends E, E2 extends E, E3 extends E, E4 extends E>
    StrictKit4<Numbers.Four, E, E1, E2, E3, E4>
    kit(E1 e1, E2 e2, E3 e3, E4 e4) {
        return new StrictKit4Impl<>(Numbers.FOUR, e1, e2, e3, e4);
    }

    public static <E, E1 extends E, E2 extends E, E3 extends E, E4 extends E,
                      E5 extends E>
    StrictKit5<Numbers.Five, E, E1, E2, E3, E4, E5>
    kit(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5) {
        return new StrictKit5Impl<>(Numbers.FIVE, e1, e2, e3, e4, e5);
    }

    public static <E, E1 extends E, E2 extends E, E3 extends E, E4 extends E,
                      E5 extends E, E6 extends E>
    StrictKit6<Numbers.Six, E, E1, E2, E3, E4, E5, E6>
    kit(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6) {
        return new StrictKit6Impl<>(Numbers.SIX, e1, e2, e3, e4, e5, e6);
    }

    public static <E, E1 extends E, E2 extends E, E3 extends E, E4 extends E,
                      E5 extends E, E6 extends E, E7 extends E>
    StrictKit7<Numbers.Seven, E, E1, E2, E3, E4, E5, E6, E7>
    kit(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7) {
        return new StrictKit7Impl<>(Numbers.SEVEN, e1, e2, e3, e4, e5, e6, e7);
    }

    public static <E, E1 extends E, E2 extends E, E3 extends E, E4 extends E,
                      E5 extends E, E6 extends E, E7 extends E, E8 extends E>
    StrictKit8<Numbers.Eight, E, E1, E2, E3, E4, E5, E6, E7, E8>
    kit(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7, E8 e8) {
        return new StrictKit8Impl<>(Numbers.EIGHT, e1, e2, e3, e4, e5, e6, e7, e8);
    }
}
