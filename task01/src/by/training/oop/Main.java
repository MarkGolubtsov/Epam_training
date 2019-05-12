package by.training.oop;

import by.training.oop.action.TrainAction;
import by.training.oop.entity.Locomotive;
import by.training.oop.entity.PassengerWagon;
import by.training.oop.entity.Train;

public class Main {

    public static void main(String[] args) {
        Locomotive a = new Locomotive();
        TrainAction.setTail(new Train(),a);
    }
}
