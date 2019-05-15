package by.training.oop.factory;

import by.training.oop.entity.Train;
import by.training.oop.entity.Wagon;
import by.training.oop.exception.NotLocomativeException;
import by.training.oop.validator.WagonValidator;
import org.apache.log4j.Logger;

import java.util.List;

public class TrainFactory {
    private static Logger logger = Logger.getLogger(TrainFactory.class.getSimpleName());

    public Train create(Wagon head, Wagon tail,List<Wagon> wagons) throws NotLocomativeException {

        if( WagonValidator.isLocomative(head) && WagonValidator.isLocomative(tail) )
        {
          Train train = new Train();
          train.setTail(tail);
          train.setHead(head);
          train.setWagons(wagons);
          logger.info("Train was created"+train);
          return train;
        }
        throw new NotLocomativeException("One of Wagon isn't Locomotive");
    }
}
