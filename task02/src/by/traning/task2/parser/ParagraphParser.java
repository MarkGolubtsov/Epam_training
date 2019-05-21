package by.traning.task2.parser;


import by.traning.task2.entity.Paragraph;
import by.traning.task2.entity.Sentence;

import java.util.ArrayList;
import java.util.Arrays;

public class ParagraphParser {

    private static final String SENTENSE_REGEX="\\.";

    public  static void setSentence(String text, Paragraph paragraph)
    {
        String[] buf =text.split(SENTENSE_REGEX);
        ArrayList<String> sentences = new ArrayList<>(Arrays.asList(buf));
        for (int i = 0; i < sentences.size(); i++) {
            Sentence sentence = new Sentence();
            LexemeParser.setLexem(sentences.get(i).trim(), sentence);
            paragraph.addSentence(sentence);
        }


    }

}
