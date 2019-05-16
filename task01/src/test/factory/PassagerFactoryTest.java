package test.factory;

import by.training.oop.enm.ComfortLevel;
import by.training.oop.entity.PassengerWagon;
import by.training.oop.exception.NotCorrectData;
import by.training.oop.factory.PassengerWagonFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;

public class PassagerFactoryTest {

    @Test()
    public  void  createPassagerWagonTest() throws NotCorrectData {
        PassengerWagon passengerWagon;
        passengerWagon=new PassengerWagon();
        passengerWagon.setWheelsCount(8);
        passengerWagon.setCountItems(10);
        passengerWagon.setCountPassengers(21);
        passengerWagon.setComfortLevel(ComfortLevel.VIP);
        PassengerWagon actual = passengerWagon;
        ArrayList<String> params= new ArrayList<>();
        params.add(0,"8");
        params.add(1,"21");
        params.add(2,"10");
        params.add(3,"VIP");
        PassengerWagon expected = null;
             expected = (PassengerWagon) new PassengerWagonFactory().getObject(params);
        Assert.assertEquals(actual,expected,"create is correct");
    }

}
