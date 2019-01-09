package com.psocratic.workchop.util;

public final class Numbers {
    public static final One    ONE    = new One();
    public static final Two    TWO    = new Two();
    public static final Three  THREE  = new Three();
    public static final Four   FOUR   = new Four();
    public static final Five   FIVE   = new Five();
    public static final Six    SIX    = new Six();
    public static final Seven  SEVEN  = new Seven();
    public static final Eight  EIGHT  = new Eight();

    public static class One implements Number {
        One() {}

        public int value() {
            return 1;
        }
    }

    public static class Two extends One {
        Two() {}

        public int value() {
            return 2;
        }
    }

    public static class Three extends Two {
        public int value() {
            return 3;
        }
    }

    public static class Four extends Three {
        public int value() {
            return 4;
        }
    }

    public static class Five extends Four {
        public int value() {
            return 5;
        }
    }

    public static class Six extends Five {
        public int value() {
            return 6;
        }
    }

    public static class Seven extends Six {
        public int value() {
            return 7;
        }
    }

    public static class Eight extends Seven {
        public int value() {
            return 8;
        }
    }
}
