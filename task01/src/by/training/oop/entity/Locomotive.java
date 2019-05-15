package by.training.oop.entity;

import by.training.oop.enm.Engine;

import java.util.Objects;

public class Locomotive extends Wagon  {

    private Engine engine;

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Locomotive{" +
                "engine=" + engine + " wheels="+getWheelsCount()+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Locomotive that = (Locomotive) o;
        return engine == that.engine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(engine);
    }
}
