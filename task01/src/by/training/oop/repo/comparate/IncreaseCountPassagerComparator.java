package by.training.oop.repo.comparate;

import by.training.oop.entity.Train;

import java.util.Comparator;

public class IncreaseCountPassagerComparator implements Comparator<Train> {

    @Override
    public int compare(Train o1, Train o2) {
        if (o1.getCountPassagers() == o2.getCountPassagers()) {
            return 0;
        }
        if (o1.getCountPassagers() > o2.getCountPassagers()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
