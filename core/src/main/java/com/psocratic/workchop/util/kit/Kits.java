package com.psocratic.workchop.util.kit;

public final class Kits {
    private Kits() {}

    public static <E1> Kit1<E1> kit(E1 e1) {
        return KitAssemblers.<E1>one().assemble(e1);
    }

    public static <E1, E2> Kit2<E1, E2> kit(E1 e1, E2 e2) {
        return KitAssemblers.<E1, E2>two().assemble(e1, e2);
    }

    public static <E1, E2, E3> Kit3<E1, E2, E3> kit(E1 e1, E2 e2, E3 e3) {
        return KitAssemblers.<E1, E2, E3>three().assemble(e1, e2, e3);
    }

    public static <E1, E2, E3, E4> Kit4<E1, E2, E3, E4> kit(E1 e1, E2 e2, E3 e3, E4 e4) {
        return KitAssemblers.<E1, E2, E3, E4>four().assemble(e1, e2, e3, e4);
    }

    public static <E1, E2, E3, E4, E5> Kit5<E1, E2, E3, E4, E5> kit(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5) {
        return KitAssemblers.<E1, E2, E3, E4, E5>five().assemble(e1, e2, e3, e4, e5);
    }

    public static <E1, E2, E3, E4, E5, E6> Kit6<E1, E2, E3, E4, E5, E6> kit(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6) {
        return KitAssemblers.<E1, E2, E3, E4, E5, E6>six().assemble(e1, e2, e3, e4, e5, e6);
    }

    public static <E1, E2, E3, E4, E5, E6, E7> Kit7<E1, E2, E3, E4, E5, E6, E7> kit(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7) {
        return KitAssemblers.<E1, E2, E3, E4, E5, E6, E7>seven().assemble(e1, e2, e3, e4, e5, e6, e7);
    }

    public static <E1, E2, E3, E4, E5, E6, E7, E8> Kit8<E1, E2, E3, E4, E5, E6, E7, E8> kit(E1 e1, E2 e2, E3 e3, E4 e4, E5 e5, E6 e6, E7 e7, E8 e8 ) {
        return KitAssemblers.<E1, E2, E3, E4, E5, E6, E7, E8>eight().assemble(e1, e2, e3, e4, e5, e6, e7, e8);
    }
}
