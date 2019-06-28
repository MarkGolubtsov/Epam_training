package by.training.task04.entity;

import java.util.stream.Stream;

public enum Multiplying {

    SEEDS("seeds"),LEAVES("leaves"),CUTTINGS("cuttings");

    private final String type;

    Multiplying(String type) {
        this.type = type;
    }

    public static Multiplying of(String type) {
        Multiplying multiplying = Stream.of(Multiplying.values())
                .filter(s ->  s.type.equalsIgnoreCase(type))
                .findFirst().orElse(CUTTINGS);
        return multiplying;
    }

    public String getType() {
        return type;
    }
}
