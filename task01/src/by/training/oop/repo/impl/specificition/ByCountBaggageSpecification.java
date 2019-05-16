package by.training.oop.repo.impl.specificition;

import by.training.oop.entity.Train;
import by.training.oop.repo.Specification;

public class ByCountBaggageSpecification implements Specification<Train> {

    private int count;
    public ByCountBaggageSpecification(int count)
    {
        this.count=count;
    }

    public boolean match(Train tr) {
        return count ==tr.getCountBaggage();
    }
}
