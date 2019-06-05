package by.traning.task02.parser;

import by.traning.task02.entity.Composite;
import by.traning.task02.entity.Lexeme;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;

public class LexemeParser implements Handle {
    private static final String LEXEM_REGEX = "\\s";

    private static  final Logger LOGGER
            = Logger.getLogger(LexemeParser.class.getSimpleName());
    private Handle next;

    @Override
    public void setNext(final Handle h) {
    next = h;
    }

    @Override
    public void handle1(final String text, final Composite composite) {

        String[] buf = text.split(LEXEM_REGEX);
        ArrayList<String> lexems = new ArrayList<>(Arrays.asList(buf));
        if (next != null) {
            for (int i = 0; i < lexems.size(); i++) {
                Lexeme lexeme = new Lexeme();
                composite.add(lexeme);
                next.handle1(lexems.get(i), lexeme);
                LOGGER.info("Add lexeme");
            }
        } else {
            LOGGER.info("next err");

        }
    }


}
