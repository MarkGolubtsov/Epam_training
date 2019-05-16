package by.training.oop.validator;

import by.training.oop.enm.ComfortLevel;
import by.training.oop.enm.Engine;
import by.training.oop.enm.TypeWagon;

import java.io.File;

import static java.lang.Integer.parseInt;

public class TextValidator {
    private TextValidator(){}
    public static boolean isTypeWagon(String s)
    {
        try {
            TypeWagon.valueOf(s);
            return true;
        } catch (Exception ex)
        {
            return false;
        }
    }
    public  static boolean isCount(String s)
    {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception ex)
        {
            return false;
        }
    }
    public static boolean isTypeComfort(String s)
    {
        try {
            ComfortLevel.valueOf(s);
            return true;
        } catch (Exception ex)
        {
            return false;
        }
    }
    public  static  boolean isTypeEnginer(String s)
    {
        try {
            Engine.valueOf(s);
            return true;
        } catch (Exception ex)
        {
            return false;
        }
    }
    public static boolean isRealFile(String path)
    {
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            return true;
        }
        return false;
    }

}
