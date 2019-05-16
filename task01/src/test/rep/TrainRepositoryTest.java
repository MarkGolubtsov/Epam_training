package test.rep;


import by.training.oop.entity.Locomotive;
import by.training.oop.entity.PassengerWagon;
import by.training.oop.entity.Train;
import by.training.oop.entity.Wagon;
import by.training.oop.exception.NotCorrectData;
import by.training.oop.exception.NotLocomativeException;
import by.training.oop.factory.LocomotiveFactory;
import by.training.oop.factory.PassengerWagonFactory;
import by.training.oop.factory.TrainFactory;
import by.training.oop.repo.comparate.*;
import by.training.oop.repo.impl.TrainRepository;
import by.training.oop.repo.impl.specificition.ByCountBaggageSpecification;
import by.training.oop.repo.impl.specificition.ByCountPassengerSpecification;
import by.training.oop.repo.impl.specificition.BySizeWagonSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TrainRepositoryTest {

   private TrainRepository trainRepository = TrainRepository.getRepository();
    private ByCountBaggageSpecification byCountBaggageSpecification = new ByCountBaggageSpecification(8);
    private ByCountPassengerSpecification byCountPassengerSpecification = new ByCountPassengerSpecification(40);
    private BySizeWagonSpecification bySizeWagonSpecification = new BySizeWagonSpecification(1);
    private DecreaseCountBaggageComparator decreaseCountBaggageComparator = new DecreaseCountBaggageComparator();
    private IncreaseCountBaggageComparator increaseCountBaggageComparator= new IncreaseCountBaggageComparator();

    private DecreaseCountPassagerComparator decreaseCountPassagerComparator = new DecreaseCountPassagerComparator();
    private IncreaseCountPassagerComparator increaseCountPassagerComparator = new IncreaseCountPassagerComparator();
    private void addTwoTrain() throws NotCorrectData, NotLocomativeException {
        trainRepository.clear();
        ArrayList<String> params= new ArrayList<>();
        params.add(0,"8");
        params.add(1,"DIESEL");
        Locomotive head = (Locomotive) new LocomotiveFactory().getObject(params);
        Locomotive tail = (Locomotive) new LocomotiveFactory().getObject(params);

        params= new ArrayList<>();
        params.add(0,"8");
        params.add(1,"21");
        params.add(2,"10");
        params.add(3,"VIP");
        PassengerWagon passengerWagon = (PassengerWagon) new PassengerWagonFactory().getObject(params);
        ArrayList<Wagon> wagons = new ArrayList<>();
        TrainFactory trainFactory= new TrainFactory();
        wagons.add(passengerWagon);

        Train train=trainFactory.create(head,tail,wagons);

        trainRepository.add(train);

        trainRepository.add(createTrain());

    }

    private Train createTrain () throws NotLocomativeException, NotCorrectData {
        ArrayList<String> params= new ArrayList<>();
        params.add(0,"8");
        params.add(1,"DIESEL");
        Locomotive  head = (Locomotive) new LocomotiveFactory().getObject(params);
        Locomotive tail = (Locomotive) new LocomotiveFactory().getObject(params);

        params= new ArrayList<>();
        params.add(0,"12");
        params.add(1,"40");
        params.add(2,"8");
        params.add(3,"LUXE");
        PassengerWagon passengerWagon = (PassengerWagon) new PassengerWagonFactory().getObject(params);
        ArrayList<Wagon>wagons = new ArrayList<>();
        TrainFactory trainFactory= new TrainFactory();
        wagons.add(passengerWagon);
        Train train =trainFactory.create(head,tail,wagons);
        return train;
    }

    @Test
    public void testByCountBaggageSpecificztion() throws NotCorrectData, NotLocomativeException {
        addTwoTrain();
        Train actual =  trainRepository.find(byCountBaggageSpecification).get(0);
       Train expected = createTrain();
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testByCountPassengerSpecification() throws NotCorrectData, NotLocomativeException {
        addTwoTrain();
        Train actual =  trainRepository.find(byCountPassengerSpecification).get(0);
        Train expected = createTrain();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testBySizeSpecification() throws NotCorrectData, NotLocomativeException {
        addTwoTrain();
        int expected = 2;
        int actual=trainRepository.find(bySizeWagonSpecification).size();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void testComparatorCountBaggage() throws NotLocomativeException, NotCorrectData {
        addTwoTrain();
        trainRepository.sort(decreaseCountBaggageComparator);
        Train fist = trainRepository.getTrain(0);
        Train second = trainRepository.getTrain(1);

        boolean decr=(fist.getCountBaggage()-second.getCountBaggage())>-1;
        trainRepository.sort(increaseCountBaggageComparator);

         fist = trainRepository.getTrain(0);
         second = trainRepository.getTrain(1);

        boolean incr=(fist.getCountBaggage()-second.getCountBaggage())<-1;
        boolean actual= decr && incr;
        boolean expected = true;
        Assert.assertEquals(actual,expected);
    }
    @Test
    public void testComparatorCountPassagers() throws NotLocomativeException, NotCorrectData {
        addTwoTrain();
        trainRepository.sort(decreaseCountPassagerComparator);
        Train fist = trainRepository.getTrain(0);
        Train second = trainRepository.getTrain(1);

        boolean decr=(fist.getCountPassagers()-second.getCountPassagers())>-1;
        trainRepository.sort(increaseCountPassagerComparator);

        fist = trainRepository.getTrain(0);
        second = trainRepository.getTrain(1);

        boolean incr=(fist.getCountPassagers()-second.getCountPassagers())<-1;
        boolean actual= decr && incr;
        boolean expected = true;
        Assert.assertEquals(actual,expected);
    }
}
