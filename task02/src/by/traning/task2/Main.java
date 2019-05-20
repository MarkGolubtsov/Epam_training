package by.traning.task2;


import by.traning.task2.parser.TextParser;
import by.traning.task2.reader.ReaderFile;

import java.util.LinkedList;

public class Main {
    //private static  final Logger logger = Logger.getLogger(Text.class.getSimpleName());
    public static void main(String[] args)  {
      String  a =ReaderFile.getFile("D:\\EPAM_JAVA\\TASK\\task02\\src\\by\\traning\\task2\\data\\input.txt");
        LinkedList<String> res = TextParser.getParagraph(a);
        System.out.println(a.length());
    }



}
