package by.training.oop.repo.comparate;

import by.training.oop.entity.Train;

import java.util.Comparator;

public class DecreaseSizeConaparator implements Comparator<Train> {
    @Override
    public int compare(Train o1, Train o2) {
        if (o1.getSize()== o2.getSize()) {
            return 0;
        }
        if (o2.getSize() < o1.getSize()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
