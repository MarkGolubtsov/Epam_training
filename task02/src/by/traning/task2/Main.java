package by.traning.task2;


import by.traning.task2.entity.TextAll;
import by.traning.task2.parser.TextParser;
import by.traning.task2.reader.ReaderFile;

import java.util.ArrayList;

public class Main {
    //private static  final Logger logger = Logger.getLogger(TextAll.class.getSimpleName());
    public static void main(String[] args)  {
        String  text =ReaderFile.getFile("D:\\EPAM_JAVA\\TASK\\task02\\src\\by\\traning\\task2\\data\\input.txt");

        TextAll textAll1 = new TextAll();
        TextParser.getParagraph(text, textAll1);
    }



}
