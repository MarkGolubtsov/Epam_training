package by.training.oop.factory;

import by.training.oop.enm.Engine;
import by.training.oop.entity.Locomotive;
import by.training.oop.entity.Wagon;
import by.training.oop.exception.NotCorrectData;
import by.training.oop.repo.impl.TrainRepository;
import by.training.oop.validator.WagonValidator;
import org.apache.log4j.Logger;

import java.util.List;



public class LocomotiveFactory implements Factory {
    private static Logger logger = Logger.getLogger(LocomotiveFactory.class.getSimpleName());
    private int wheelsCount ;
    private  Engine engine;

    public Wagon getObject(List<String> params) throws NotCorrectData {
        createParam(params);

        if (WagonValidator.isCorrectWheelsCount(wheelsCount))
        {
            Locomotive locomotive = new Locomotive();
            locomotive.setEngine(engine);
            locomotive.setWheelsCount(wheelsCount);
            logger.info("Locomotive was created," +locomotive.toString());
            return locomotive;
        }
        throw new NotCorrectData("Need  correct data");
    }

    private void createParam(List<String> params) throws NotCorrectData {
        try {
            wheelsCount = Integer.parseInt(params.get(0));
            engine=Engine.valueOf(params.get(1));
        } catch (Exception ex){
            throw new NotCorrectData("Need  correct data");
        }

    }

}
