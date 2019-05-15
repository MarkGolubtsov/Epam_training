package by.training.oop.repo.impl;

import by.training.oop.entity.Train;
import by.training.oop.repo.Repository;
import by.training.oop.repo.Specification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainRepository implements Repository<Train> {

    private static TrainRepository repository;
    private TrainRepository(){}

    public static TrainRepository getRepository(){
        if(repository == null){
            repository = new TrainRepository();
        }
        return repository;
    }

     private  ArrayList<Train> trains = new ArrayList<>();

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
        int i = 0;
        Train train;
        while (i<trains.size())
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
    public String toString() {
        return "TrainRepository{" +
                "trains=" + trains +
                '}';
    }

    @Override
    public void sort(Comparator<Train> comparator) {
        trains.sort(comparator);
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
               i++;
            }
            else
            {
                i++;
            }
        }
        return result;
    }
}
