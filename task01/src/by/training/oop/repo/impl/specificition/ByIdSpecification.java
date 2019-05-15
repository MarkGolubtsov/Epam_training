package by.training.oop.repo.impl.specificition;

import by.training.oop.entity.Train;

public class ByIdSpecification {
    private int id;
    public ByIdSpecification(int id)
    {
        this.id=id;
    }

    public boolean match(Train tr) {
        return this.id ==tr.getId();
    }
}
