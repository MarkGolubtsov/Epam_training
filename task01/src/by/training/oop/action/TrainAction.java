package by.training.oop.action;

import by.training.oop.entity.PassengerWagon;
import by.training.oop.entity.Train;
import by.training.oop.entity.Wagon;
import by.training.oop.validator.WagonValidator;

import java.awt.*;
import java.util.List;

public  class  TrainAction {
private TrainAction(){}

    public static void addWagon(Train tr, Wagon wagon)
    {
        if ( !WagonValidator.isLocomative(wagon) )
        {
            List<Wagon> wagons= tr.getWagons();
            wagons.add(wagon);
            tr.setWagons(wagons);
        }

    }

    public static void setHead(Train tr,Wagon wagon)
    {
            tr.setHead(wagon);
    }
    public static void setTail(Train tr,Wagon wagon)
    {
            tr.setTail(wagon);
    }



    public static void deleteWagon(Train tr, Wagon wagon)
    {
        List<Wagon> wagons= tr.getWagons();
        wagons.remove(wagon);
        tr.setWagons(wagons);
    }

    public static int countBaggage(Train tr)
    {
        int count = 0;
        List<Wagon> wagons = tr.getWagons();
        for (Wagon wagon : wagons)
        {
            int localCount = ((PassengerWagon)wagon).getCountItems();
            count=count+localCount;
        }
        return count;
    }
    public static int countPassagers(Train tr)
    {
        int count = 0;
        List<Wagon> wagons = tr.getWagons();
        for (Wagon wagon : wagons)
        {
            int localCount = ((PassengerWagon)wagon).getCountPassengers();
            count=count+localCount;
        }

        return  count;
    }


}
