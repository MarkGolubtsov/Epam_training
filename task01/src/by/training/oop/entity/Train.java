package by.training.oop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Train implements Serializable {

    private  int trainID;
    private Wagon head;
    private Wagon tail;
    private ArrayList<Wagon> wagons;

    public int getTrainID() {
        return trainID;
    }

    public void setTrainID(int trainID) {
        this.trainID = trainID;
    }

    public Wagon getHead() {
        return head;
    }

    public void setHead(Wagon head) {
        this.head = head;
    }

    public Wagon getTail() {
        return tail;
    }

    public void setTail(Wagon tail) {
        this.tail = tail;
    }

    public ArrayList<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(ArrayList<Wagon> wagons) {
        this.wagons = wagons;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return trainID == train.trainID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainID, head, tail, wagons);
    }


}
