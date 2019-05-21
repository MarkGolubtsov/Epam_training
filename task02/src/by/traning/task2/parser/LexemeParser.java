package by.traning.task2.parser;

import by.traning.task2.entity.Lexeme;
import by.traning.task2.entity.Sentence;

import java.util.ArrayList;
import java.util.Arrays;

public class LexemeParser {
    private static final String LEXEM_REGEX = "\\s";

    public static void setLexem(String text, Sentence sentence)
    {
        String[] buf =text.split(LEXEM_REGEX);
        ArrayList<String> lexems = new ArrayList<>(Arrays.asList(buf));
        for (int i = 0; i < lexems.size(); i++) {
           Lexeme lexeme = new Lexeme();
            SymbolParser.setSymbols(lexems.get(i),lexeme);
            sentence.addLexem(lexeme);
        }

    }
}
