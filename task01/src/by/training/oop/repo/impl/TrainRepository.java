package by.training.oop.repo.impl;

import by.training.oop.entity.Train;
import by.training.oop.exception.NotCorrectData;
import by.training.oop.repo.Repository;
import by.training.oop.repo.Specification;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TrainRepository implements Repository<Train> {

   private static Logger logger = Logger.getLogger(TrainRepository.class.getSimpleName());

    private static TrainRepository repository;
    private int numberID;
    private int size;

    public int getSize() {
        return size;
    }

    private TrainRepository(){
        numberID=0;
        logger.info("Repository was create");
    }

    public static TrainRepository getRepository(){
        if(repository == null){
            repository = new TrainRepository();
        }
        return repository;
    }

     private  ArrayList<Train> trains = new ArrayList<>();

    @Override
    public void add(Train item) {
        item.setId(numberID);
        trains.add(item);
        numberID=numberID+1;

        if(isChangeSize())
        {
            logger.info("Train was add");
        }
        size=trains.size();

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

        if(isChangeSize())
        {
            logger.info("Train was remove "+spec.getClass().getSimpleName());
        }
        size=trains.size();
    }
    public void clear()
    {
        logger.info("Repository clear");
        numberID=0;
        trains.clear();
    }
    public Train getTrain(int i) throws NotCorrectData {
        if(i<getSize()) {
            return trains.get(i);
        }
        throw new NotCorrectData("");
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
        logger.info("Train was sort, "+comparator.getClass().getSimpleName());
        }

    @Override
    public List<Train> find(Specification<Train> spec) {
        List<Train> result = new ArrayList<>();
        int i = 0;
        Train train;
        while (i<size)
        {
            train=trains.get(i);
            if (spec.match(train))
            {
               result.add(train);
            }
            i++;

        }
        if (!result.isEmpty())
        {
            logger.info("Train was found, " + spec.getClass().getSimpleName());
        }
        return result;
    }
    private boolean isChangeSize()
    {
        return trains.size()!=size;
    }

}
