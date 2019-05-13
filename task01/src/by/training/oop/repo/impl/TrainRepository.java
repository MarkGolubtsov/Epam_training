package by.training.oop.repo.impl;

import by.training.oop.entity.Train;
import by.training.oop.repo.Repository;
import by.training.oop.repo.Specification;

import java.util.ArrayList;
import java.util.List;

public class TrainRepository implements Repository<Train> {

     private  List<Train> trains = new ArrayList<>();

    @Override
    public void add(Train item) {
        trains.add(item);
    }
    @Override
    public void remove(Train item) {
        trains.remove(item);
    }

    @Override
    public void remove(Specification<Train> spec) {
        int size=trains.size();
        int i = 0;
        Train train;
        while (i<size)
        {
            train=trains.get(i);
            if (spec.match(train))
            {
                trains.remove(train);
            }
            else
            {
                i++;
            }
        }
    }

    @Override
    public void sort(Specification<Train> spec) {

        }

    @Override
    public List<Train> find(Specification<Train> spec) {
        List<Train> result = new ArrayList<>();
        int size=trains.size();
        int i = 0;
        Train train;
        while (i<size)
        {
            train=trains.get(i);
            if (spec.match(train))
            {
               result.add(train);
            }
            else
            {
                i++;
            }
        }
        return result;
    }
}
