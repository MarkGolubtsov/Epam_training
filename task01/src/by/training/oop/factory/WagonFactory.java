package by.training.oop.factory;

import by.training.oop.enm.TypeWagon;

import java.util.Optional;

public class WagonFactory {
    public  Factory getFactory(TypeWagon typeWagon) {
        switch (typeWagon){
            case LOCOMOTIVE:
               return new LocomotiveFactory();
            case PASSAGER_WAGON:
                return new PassengerWagonFactory();
            default:return null;
        }

    }
}
