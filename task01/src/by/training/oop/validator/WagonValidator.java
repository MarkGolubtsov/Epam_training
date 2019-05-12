package by.training.oop.validator;

import by.training.oop.entity.Locomotive;
import by.training.oop.entity.Wagon;

public class WagonValidator {
private  WagonValidator(){}
    public static boolean isLocomative(Wagon wagon)
    {
        return Locomotive.class.equals(wagon.getClass());
    }

    public static boolean isCorrectWheelsCount(int count)
    {
        boolean result;
        if ((count>0) && (count % 2 ==0)) {
            result = true;
        }
        else {
            result=false;
        }
        return  result;
    }

    public static boolean isCorrectCount(int count)
    {
        boolean result ;
        if (count>-1)
        {
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }
}
