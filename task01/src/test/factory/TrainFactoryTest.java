package test.factory;

import by.training.oop.enm.ComfortLevel;
import by.training.oop.enm.Engine;
import by.training.oop.entity.Locomotive;
import by.training.oop.entity.PassengerWagon;
import by.training.oop.entity.Train;
import by.training.oop.entity.Wagon;
import by.training.oop.exception.NotLocomativeException;
import by.training.oop.factory.TrainFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TrainFactoryTest {

    private  TrainFactory factory = new TrainFactory();

    @Test
    public void createTrainTest() throws NotLocomativeException {
        Train train = new Train();
        Locomotive locomotive;
        locomotive =new Locomotive();
        locomotive.setWheelsCount(8);
        locomotive.setEngine(Engine.DIESEL);

        train.setHead(locomotive);

        Locomotive locomotive1;
        locomotive1 =new Locomotive();
        locomotive1.setWheelsCount(8);
        locomotive1.setEngine(Engine.DIESEL);

        train.setTail(locomotive1);

        PassengerWagon passengerWagon=new PassengerWagon();
        passengerWagon.setWheelsCount(8);
        passengerWagon.setCountItems(10);
        passengerWagon.setCountPassengers(21);
        passengerWagon.setComfortLevel(ComfortLevel.VIP);
        train.addWagon(passengerWagon);

        Train actual= train;
        ArrayList<Wagon> wagons = new ArrayList<>();
        wagons.add(passengerWagon);
        Train expected = factory.create(locomotive1,locomotive,wagons);
        Assert.assertEquals(actual,expected,"create is correct");


    }
}
