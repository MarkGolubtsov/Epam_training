package by.training.oop.repo.comparate;

import by.training.oop.entity.Train;

import java.util.Comparator;

public class DecreaseCountBaggageComparator implements Comparator<Train> {
    @Override
    public int compare(Train o1, Train o2) {
       if (o1.getCountBaggage() == o2.getCountBaggage()) {
           return 0;
       }
      if (o2.getCountBaggage() > o1.getCountBaggage()) {
           return 1;
      }
       else {
           return -1;
       }
    }
}
