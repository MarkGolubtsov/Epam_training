package by.training.oop.entity;

import java.io.Serializable;

public abstract  class Wagon implements Serializable {

    private int indexInTrain;

    private int wagonID;

    public int getIndexInTrain() {
        return indexInTrain;
    }

    public void setIndexInTrain(int indexInTrain) {
        this.indexInTrain = indexInTrain;
    }

    public int getID() {
        return wagonID;
    }

    public void setID(int id) {
        this.wagonID = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wagon wagon = (Wagon) o;
        return indexInTrain == wagon.indexInTrain &&
                wagonID == wagon.wagonID;
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 193;
        int result = 1;
        result = PRIME * result + getID();
        return result;
    }
}
