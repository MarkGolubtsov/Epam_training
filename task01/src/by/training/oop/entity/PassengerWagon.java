package by.training.oop.entity;

import by.training.oop.enm.ComfortLevel;

import java.util.ArrayList;
import java.util.Objects;

public class PassengerWagon extends Wagon {

    private int countPassengers;

    private ComfortLevel comfortLevel;

    private  int countItems;

    public int getCountPassengers() {
        return countPassengers;
    }

    public void setCountPassengers(int countPassengers) {
        this.countPassengers = countPassengers;
    }

    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(ComfortLevel comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    public int getCountItems() {
        return countItems;
    }

    public void setCountItems(int countItems) {
        this.countItems = countItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PassengerWagon that = (PassengerWagon) o;
        return countPassengers == that.countPassengers &&
                countItems == that.countItems &&
                comfortLevel == that.comfortLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countPassengers, comfortLevel, countItems);
    }
}
