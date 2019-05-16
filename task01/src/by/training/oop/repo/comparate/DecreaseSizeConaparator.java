package by.training.oop.repo.comparate;

import by.training.oop.entity.Train;

import java.util.Comparator;

public class DecreaseSizeConaparator implements Comparator<Train> {
    @Override
    public int compare(Train o1, Train o2) {
        if (o1.getCountWagon()== o2.getCountWagon()) {
            return 0;
        }
        if (o2.getCountWagon() < o1.getCountWagon()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
