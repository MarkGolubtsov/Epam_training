package by.training.oop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Passenger implements Serializable {

    private int passengerID;

    private String name;

    private ArrayList<Item> items;

    public Passenger(String name, int passengerID){
        this.name = name;
        this.passengerID = passengerID;
        this.items = new ArrayList<>();
    }

    public int getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(int passengerID) {
        this.passengerID = passengerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return passengerID == passenger.passengerID &&
                name.equals(passenger.name) &&
                items.equals(passenger.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passengerID, name, items);
    }
}
