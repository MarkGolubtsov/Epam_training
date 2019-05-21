package by.traning.task2.parser;

import by.traning.task2.entity.Paragraph;
import by.traning.task2.entity.TextAll;

import java.util.ArrayList;
import java.util.Arrays;

public class TextParser {
    private static final String PARAGRAPH_SPLIT_REGEX = "\n[ ]{4}";
    private static final String NEW_LINE_REGEX="\r\n";

    public  static void getParagraph(String text, TextAll textAll)
    {
        String[] buf =text.split(PARAGRAPH_SPLIT_REGEX);
        String buf1;
        ArrayList<String> paragraphs = new ArrayList<>(Arrays.asList(buf));

        for (int i = 0; i < paragraphs.size(); i++) {
            Paragraph paragraph = new Paragraph();
            ParagraphParser.setSentence(paragraphs.get(i), paragraph);
            textAll.addParagraph(paragraph);
        }

    }
}