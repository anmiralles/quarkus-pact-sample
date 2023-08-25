package org.acme.fruits;

import java.util.List;

public final class TestData {

    private TestData() {
    }

    public static List<Fruit> getFruits() {
        return List.of(
                new Fruit(1L, "Cherry"),
                new Fruit(2L, "Apple"),
                new Fruit(3L, "Banana")
        );
    }

    public static Fruit getFruit() {
        return new Fruit(1L, "Cherry");
    }

}