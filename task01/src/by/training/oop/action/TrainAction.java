package by.training.oop.action;

import by.training.oop.entity.Locomotive;
import by.training.oop.entity.PassengerWagon;
import by.training.oop.entity.Train;
import by.training.oop.entity.Wagon;

import java.awt.*;
import java.util.List;

public  class  TrainAction {

    public static void addWagon(Train tr, Wagon wagon)
    {
        if ( !isLocomative(wagon) )
        {
            List<Wagon> wagons= tr.getWagons();
            wagons.add(wagon);
            tr.setWagons(wagons);
        }

    }

    public static void setHead(Train tr,Wagon wagon)
    {
        if (isLocomative(wagon))
        {
            tr.setHead(wagon);
        }
    }
    public static void setTail(Train tr,Wagon wagon)
    {
        if (isLocomative(wagon))
        {
            tr.setTail(wagon);
        }
    }

    private static boolean isLocomative(Wagon wagon)
    {
        return Locomotive.class.equals(wagon.getClass());
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
