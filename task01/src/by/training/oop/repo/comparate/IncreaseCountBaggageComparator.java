package by.training.oop.repo.comparate;

import by.training.oop.entity.Train;
import by.training.oop.entity.Wagon;

import java.util.Comparator;

public class IncreaseCountBaggageComparator implements Comparator<Train> {

    @Override
    public int compare(Train o1, Train o2) {
        if (o1.getCountBaggage() == o2.getCountBaggage()) {
            return 0;
        }
        if (o1.getCountBaggage() > o2.getCountBaggage()) {
            return 1;
        }
        else {
            return -1;
        }
    }
}
