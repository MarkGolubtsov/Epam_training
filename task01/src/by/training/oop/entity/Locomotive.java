package by.training.oop.entity;

import by.training.oop.enm.Engine;

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
                "engine=" + engine +
                '}';
    }
}
