package by.traning.task02.parser;

import by.traning.task02.entity.Component;
import by.traning.task02.entity.Composite;
import by.traning.task02.entity.Paragraph;


import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class TextParser implements Handle {
    private static final String PARAGRAPH_SPLIT_REGEX = "\n[ ]{4}";

    private Handle next;
    private static  final Logger logger = Logger.getLogger(TextParser.class.getSimpleName());

    @Override
    public void setNext(Handle h) {
    next=h;
    }

    @Override
    public void handle1(String text, Composite composite) {
        String[] buf =text.split(PARAGRAPH_SPLIT_REGEX);
        ArrayList<String> paragraphs = new ArrayList<>(Arrays.asList(buf));

        if (next!=null) {
            for (int i = 0; i < paragraphs.size(); i++) {
                Paragraph paragraph = new Paragraph();
                composite.add(paragraph);
                next.handle1(paragraphs.get(i), paragraph);
                logger.info("Add paragrapg");
            }
        }
        else
            {
                logger.info("error next");
            }

    }
}