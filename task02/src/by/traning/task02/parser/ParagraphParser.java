package by.traning.task02.parser;


import by.traning.task02.entity.Sentence;
import org.apache.log4j.Logger;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Handle {
    public static final String REGEX_SENTENCE= "([^(\\.|!|\\?)]+)(\\.\\.\\.|\\.|!|\\?)";
    private static final String SENTENSE_REGEX="\\.";
    private static  final Logger logger = Logger.getLogger(ParagraphParser.class.getSimpleName());
  private Handle next;

    @Override
    public void setNext(Handle h) {
        next=h;
    }

    @Override
    public void handle1(String text, by.traning.task02.entity.Composite composite) {
        //String[] buf =text.split(SENTENSE_REGEX);

        ArrayList<String> sentences = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEX_SENTENCE);

        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            sentences.add(text.substring(matcher.start(), matcher.end()));
        }


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
