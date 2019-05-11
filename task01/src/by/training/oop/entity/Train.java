package by.training.oop.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Train {

    private Wagon head;

    private Wagon tail;

    private List<Wagon> wagons;

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

    public List<Wagon> getWagons() {
        return wagons;
    }

    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Train train = (Train) o;
        return Objects.equals(head, train.head) &&
                Objects.equals(tail, train.tail) &&
                Objects.equals(wagons, train.wagons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, wagons);
    }
}
