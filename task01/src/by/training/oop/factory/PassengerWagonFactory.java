package by.training.oop.factory;

import by.training.oop.enm.ComfortLevel;
import by.training.oop.entity.PassengerWagon;
import by.training.oop.entity.Wagon;
import by.training.oop.exception.NotCorrectData;
import by.training.oop.validator.WagonValidator;


import java.util.List;

public class PassengerWagonFactory implements Factory{

    private  int wheelsCount;
    private int countPassagers;
    private  int countItems;
    private ComfortLevel comfortLevel;
    public  Wagon getObject(List<String> params) throws NotCorrectData {
        createParam(params);
        if (WagonValidator.isCorrectWheelsCount(wheelsCount) && WagonValidator.isCorrectCount(countPassagers) && (WagonValidator.isCorrectCount(countItems)))
        {
            PassengerWagon passengerWagon= new PassengerWagon();

            return passengerWagon;
        }
        throw new NotCorrectData("Need  correct data");

    }
    private void createParam(List<String> params) throws NotCorrectData {
        wheelsCount=Integer.parseInt(params.get(0));
        countPassagers=Integer.parseInt(params.get(1));
        countItems=Integer.parseInt(params.get(2));
        try {
            comfortLevel = ComfortLevel.valueOf(params.get(3));
        } catch (IllegalArgumentException ex){
            throw new NotCorrectData("Need  correct data");
        }

    }
}
