package by.training.task04.entity;

import java.util.Objects;

public class GrowingTips {


    private double temperature;
    private boolean isLikeLighting;
    private int watering;

    public GrowingTips(double t, boolean l, int w) {
        temperature=t;
        isLikeLighting=l;
        watering=w;
    }
    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public boolean isLikeLighting() {
        return isLikeLighting;
    }

    public void isLikeLighting(boolean lighting) {
        this.isLikeLighting = lighting;
    }

    public int  getWatering() {
        return watering;
    }

    public void setWatering(int  watering) {
        this.watering = watering;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrowingTips that = (GrowingTips) o;
        return Double.compare(that.temperature, temperature) == 0 &&
                isLikeLighting == that.isLikeLighting &&
                Double.compare(that.watering, watering) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, isLikeLighting, watering);
    }

    @Override
    public String toString() {
        return "GrowingTips{" +
                "temperature=" + temperature +
                ", isLikeLighting=" + isLikeLighting +
                ", watering=" + watering +
                '}';
    }
}
