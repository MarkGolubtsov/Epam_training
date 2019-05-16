package by.training.oop.repo.impl.specificition;

import by.training.oop.entity.Train;
import by.training.oop.repo.Specification;

public class ByIdSpecification implements Specification<Train> {
    private int id;
    public ByIdSpecification(int id)
    {
        this.id=id;
    }

    public boolean match(Train tr) {
        return this.id ==tr.getId();
    }
}
