package by.traning.task02.parser;
import by.traning.task02.entity.Composite;
import by.traning.task02.entity.Paragraph;
import org.apache.log4j.Logger;


import java.util.ArrayList;
import java.util.Arrays;

public class TextParser implements Handle {
    private static final String PARAGRAPH_SPLIT_REGEX = "\n[ ]{4}";

    private Handle next;
    private static  final Logger LOGGER
            = Logger.getLogger(TextParser.class.getSimpleName());

    @Override
    public void setNext(final Handle h) {
    next = h;
    }

    @Override
    public void handle1(final String text, final Composite composite) {
        String[] buf = text.split(PARAGRAPH_SPLIT_REGEX);
        ArrayList<String> paragraphs = new ArrayList<>(Arrays.asList(buf));

        if (next != null) {
            for (int i = 0; i < paragraphs.size(); i++) {
                Paragraph paragraph = new Paragraph();
                composite.add(paragraph);
                next.handle1(paragraphs.get(i), paragraph);
                LOGGER.info("Add paragrapg");
            }
        } else {
                LOGGER.info("error next");
            }

    }
}
