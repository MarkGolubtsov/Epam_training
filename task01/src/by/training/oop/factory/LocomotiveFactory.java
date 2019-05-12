package by.training.oop.factory;

import by.training.oop.enm.Engine;
import by.training.oop.entity.Locomotive;
import by.training.oop.entity.Wagon;
import by.training.oop.exception.NotCorrectData;
import by.training.oop.validator.WagonValidator;

import java.util.ArrayList;
import java.util.List;

import static by.training.oop.enm.Engine.*;


public class LocomotiveFactory implements Factory {

    private int wheelsCount ;
    private  Engine engine;

    public Wagon getObject(List<String> params) throws NotCorrectData {
        parserParam(params);

        if (WagonValidator.isCorrectWheelsCount(wheelsCount))
        {
            Locomotive locomotive = new Locomotive();
            locomotive.setEngine(engine);
            locomotive.setWheelsCount(wheelsCount);
            return locomotive;
        }
        throw new NotCorrectData("Need a coorrect data");
    }

    private void parserParam(List<String> params)
    {
        String engine=params.get(0);
        wheelsCount = Integer.parseInt(params.get(1));
        switch (engine) {
            case "electric":
                this.engine =ELECTRIC_MOTOR;
                break;
            case "petrol":
                this.engine = PETROL;
                break;
            case "diesel":
                this.engine=DIESEL;
                break;
        }
    }

}
