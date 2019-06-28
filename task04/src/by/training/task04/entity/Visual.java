package by.training.task04.entity;

import java.util.Objects;

public class Visual {
    private String color;
    private int size;





    public Visual(String c, int s) {
        color=c;
        size=s;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visual visual = (Visual) o;
        return size == visual.size &&
                color.equals(visual.color);
    }
    @Override
    public int hashCode() {
        return Objects.hash(color, size);
    }

    @Override
    public String toString() {
        return "Visual{" +
                "color='" + color + '\'' +
                ", size=" + size +
                '}';
    }
}
