package by.training.oop.entity;

import by.training.oop.enm.ComfortLevel;

import java.util.ArrayList;

public class PassengerWagon extends Wagon {

    private int countSeats;

    private ArrayList<Passenger> passengers;

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }
    public void setPassengers(ArrayList<Passenger> passengers) {
        this.passengers = passengers;
    }

    private ComfortLevel comfortLevel;

    public int getCountSeats() {
        return countSeats;
    }

    public void setCountSeats(int countSeats) {
        this.countSeats = countSeats;
    }


    public ComfortLevel getComfortLevel() {
        return comfortLevel;
    }

    public void setComfortLevel(ComfortLevel comfortLevel) {
        this.comfortLevel = comfortLevel;
    }

    @Override
    public String toString() {
        return "PassengerWagon{" +
                "countSeats=" + countSeats +
                ", passengers=" + passengers +
                ", comfortLevel=" + comfortLevel +
                '}';
    }
}
