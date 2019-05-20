package by.traning.task2.parser;

import by.traning.task2.entity.Paragraph;

import java.util.Arrays;
import java.util.LinkedList;
//TODo GOOD
public class TextParser {

    public  static LinkedList<String> getParagraph(String text)
    {
        LinkedList<String> paragraphs = new LinkedList<>();

        String[] buf =text.split("\\n{2,}");

        LinkedList<String> з = new  LinkedList<String>(
                Arrays.asList(buf));
        return  paragraphs;
    }
}