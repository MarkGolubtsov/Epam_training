package test.factory;

import by.training.oop.enm.Engine;
import by.training.oop.entity.Locomotive;
import by.training.oop.exception.NotCorrectData;
import by.training.oop.factory.LocomotiveFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class LocomotiveFactoryTest {
    @Test()
    public  void  createLocomativeTest() throws NotCorrectData {
        Locomotive locomotive;
        locomotive =new Locomotive();
        locomotive.setWheelsCount(8);
        locomotive.setEngine(Engine.DIESEL);
        Locomotive expected = locomotive;
        ArrayList<String> params= new ArrayList<>();
        params.add(0,"8");
        params.add(1,"DIESEL");
        Locomotive actual = null;
        actual = (Locomotive) new LocomotiveFactory().getObject(params);
        Assert.assertEquals(actual,expected,"create is correct");
    }
}
