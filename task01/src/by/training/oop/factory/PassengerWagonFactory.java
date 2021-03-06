package by.training.oop.factory;

import by.training.oop.enm.ComfortLevel;
import by.training.oop.entity.PassengerWagon;
import by.training.oop.entity.Wagon;
import by.training.oop.exception.NotCorrectData;
import by.training.oop.validator.WagonValidator;
import org.apache.log4j.Logger;


import java.util.List;

public class PassengerWagonFactory implements Factory{
    private static Logger logger = Logger.getLogger(PassengerWagonFactory.class.getSimpleName());
    private  int wheelsCount;
    private int countPassagers;
    private  int countItems;
    private ComfortLevel comfortLevel;

    private static final NotCorrectData EXCEPTION = new NotCorrectData("Need  correct data");

    public  Wagon getObject(List<String> params) throws NotCorrectData {
        createParam(params);
        if (WagonValidator.isCorrectWheelsCount(wheelsCount) && WagonValidator.isCorrectCount(countPassagers) && (WagonValidator.isCorrectCount(countItems)))
        {
            PassengerWagon passengerWagon= new PassengerWagon();
            passengerWagon.setCountPassengers(countPassagers);
            passengerWagon.setCountItems(countItems);
            passengerWagon.setComfortLevel(comfortLevel);
            passengerWagon.setWheelsCount(wheelsCount);
            logger.info("PassagerWagon was created"+passengerWagon);
            return passengerWagon;
        }
        throw EXCEPTION;

    }
    private void createParam(List<String> params) throws NotCorrectData {
        try {
            wheelsCount= Integer.parseInt(params.get(0));
            countPassagers=Integer.parseInt(params.get(1));
            countItems=Integer.parseInt(params.get(2));
        }
         catch (NumberFormatException ex){
             throw EXCEPTION;
         }

        try {
            comfortLevel = ComfortLevel.valueOf(params.get(3));
        } catch (IllegalArgumentException ex){
            throw EXCEPTION;
        }

    }
}
