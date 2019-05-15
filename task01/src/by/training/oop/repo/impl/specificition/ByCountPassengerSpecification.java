package by.training.oop.repo.impl.specificition;


import by.training.oop.entity.Train;
import by.training.oop.repo.Specification;

public class ByCountPassengerSpecification implements Specification<Train> {
    private int count;

    public ByCountPassengerSpecification(int count)
    {
        this.count=count;
    }

    public boolean match(Train tr) {
        return count==tr.getCountPassagers();
    }
}
