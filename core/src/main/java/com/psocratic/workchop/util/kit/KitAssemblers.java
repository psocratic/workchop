package com.psocratic.workchop.util.kit;

public final class KitAssemblers {
    private KitAssemblers() {}

    public static <E1> Kit1Assembler<E1, Kit1<E1>> one() {
        return new Kit1AssemblerImpl<>();
    }

    public static <E1, E2> Kit2Assembler<E1, E2, Kit2<E1, E2>> two() {
        return new Kit2AssemblerImpl<>();
    }

    public static <E1, E2, E3> Kit3Assembler<E1, E2, E3, Kit3<E1, E2, E3>> three() {
        return new Kit3AssemblerImpl<>();
    }

    public static <E1, E2, E3, E4> Kit4Assembler<E1, E2, E3, E4, Kit4<E1, E2, E3, E4>> four() {
        return new Kit4AssemblerImpl<>();
    }

    public static <E1, E2, E3, E4, E5> Kit5Assembler<E1, E2, E3, E4, E5, Kit5<E1, E2, E3, E4, E5>> five() {
        return new Kit5AssemblerImpl<>();
    }

    public static <E1, E2, E3, E4, E5, E6> Kit6Assembler<E1, E2, E3, E4, E5, E6, Kit6<E1, E2, E3, E4, E5, E6>> six() {
        return new Kit6AssemblerImpl<>();
    }

    public static <E1, E2, E3, E4, E5, E6, E7> Kit7Assembler<E1, E2, E3, E4, E5, E6, E7, Kit7<E1, E2, E3, E4, E5, E6, E7>> seven() {
        return new Kit7AssemblerImpl<>();
    }

    public static <E1, E2, E3, E4, E5, E6, E7, E8> Kit8Assembler<E1, E2, E3, E4, E5, E6, E7, E8, Kit8<E1, E2, E3, E4, E5, E6, E7, E8>> eight() {
        return new Kit8AssemblerImpl<>();
    }
}
