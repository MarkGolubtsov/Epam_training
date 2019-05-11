package by.training.oop.entity;

import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {

    private int itemID;


    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemID == item.itemID &&
                name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemID, name);
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", name='" + name + '\'' +
                '}';
    }
}
