package by.training.task04.entity;

import java.util.Objects;

public class Flower {
    private String name;
    private Soil soil;
    private String origin;
    private Visual  visual;
    private GrowingTips growingTips;
    private Multiplying multiplying;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Soil getSoil() {
        return soil;
    }

    public void setSoil(Soil soil) {
        this.soil = soil;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Visual getVisual() {
        return visual;
    }

    public void setVisual(Visual visual) {
        this.visual = visual;
    }

    public GrowingTips getGrowingTips() {
        return growingTips;
    }

    public void setGrowingTips(GrowingTips growingTips) {
        this.growingTips = growingTips;
    }

    public Multiplying getMultiplying() {
        return multiplying;
    }

    public void setMultiplying(Multiplying multiplying) {
        this.multiplying = multiplying;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Objects.equals(name, flower.name) &&
                soil == flower.soil &&
                Objects.equals(origin, flower.origin) &&
                Objects.equals(visual, flower.visual) &&
                Objects.equals(growingTips, flower.growingTips) &&
                multiplying == flower.multiplying;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, soil, origin, visual, growingTips, multiplying);
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", soil=" + soil +
                ", origin='" + origin + '\'' +
                ", visual=" + visual +
                ", growingTips=" + growingTips +
                ", multiplying=" + multiplying +
                '}';
    }
}
