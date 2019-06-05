package by.traning.task02.parser;


import by.traning.task02.entity.Composite;
import by.traning.task02.entity.Sentence;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser implements Handle {
    public static final String REGEX_SENTENCE
            = "([^(\\.|!|\\?)]+)(\\.\\.\\.|\\.|!|\\?)";
    private static  final Logger LOGGER
            = Logger.getLogger(ParagraphParser.class.getSimpleName());
    private Handle next;

    @Override
    public void setNext(final Handle h) {
        next = h;
    }

    @Override
    public void handle1(final String text, final Composite composite) {
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

                LOGGER.info("add sentence");
            }
        }  else {
            LOGGER.info("next err");
        }
    }
}
