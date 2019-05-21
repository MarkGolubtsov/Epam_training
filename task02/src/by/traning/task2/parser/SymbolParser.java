package by.traning.task2.parser;

import by.traning.task2.enm.TypeSympol;
import by.traning.task2.entity.Lexeme;
import by.traning.task2.entity.Symbol;

import java.util.ArrayList;

public class SymbolParser {

    private static final String PUNCTUATION= "\",.?!";

    public static void setSymbols(String text, Lexeme lexeme)
    {
        for (int i = 0; i < text.length(); i++) {
            Character buf=text.charAt(i);
            Symbol symbol = new Symbol();

            if (PUNCTUATION.contains(buf.toString()))
            {
                symbol.setTypeSympol(TypeSympol.PUNCTUATION_MARK);
            } else {
                symbol.setTypeSympol(TypeSympol.LETTER);
            }
            symbol.setSymbol(buf);
            lexeme.addSymbol(symbol);
        }


    }
}
