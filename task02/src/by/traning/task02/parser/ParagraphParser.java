package by.traning.task02.parser;


import by.traning.task02.entity.Sentence;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

public class ParagraphParser implements Handle {

    private static final String SENTENSE_REGEX="\\.";
    private static  final Logger logger = Logger.getLogger(ParagraphParser.class.getSimpleName());
  private Handle next;

    @Override
    public void setNext(Handle h) {
        next=h;
    }

    @Override
    public void handle1(String text, by.traning.task02.entity.Composite composite) {
        String[] buf =text.split(SENTENSE_REGEX);
        ArrayList<String> sentences = new ArrayList<>(Arrays.asList(buf));

        if (next != null) {
            for (int i = 0; i < sentences.size(); i++) {
                Sentence sentence = new Sentence();
                composite.add(sentence);
                next.handle1(sentences.get(i).trim(), sentence);

                logger.info("add sentence");
            }
        }  else
        {
            logger.info("next err");
        }
    }
}
