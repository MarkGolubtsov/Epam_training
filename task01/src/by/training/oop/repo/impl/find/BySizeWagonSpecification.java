package by.training.oop.repo.impl.find;

import by.training.oop.entity.Train;
import by.training.oop.repo.Specification;

public class BySizeWagonSpecification implements Specification<Train> {
    private int count;

    public BySizeWagonSpecification(int count)
    {
        this.count=count;
    }

    public boolean match(Train tr) {
        return count ==tr.getSize();
    }

}
