package by.traning.task02.parser;

import by.traning.task02.enm.TypeSympol;
import by.traning.task02.entity.Composite;
import by.traning.task02.entity.Symbol;

public class SymbolParser implements Handle {

    private static final String PUNCTUATION = ",.";

    private Handle next = null;



    @Override
    public void setNext(final Handle h) {
        next = h;
    }

    @Override
    public void handle1(final String text, final Composite composite) {
        for (int i = 0; i < text.length(); i++) {
            Character buf = text.charAt(i);
            Symbol symbol = new Symbol();

            if (PUNCTUATION.contains(buf.toString())) {
                symbol.setTypeSympol(TypeSympol.PUNCTUATION_MARK);
            } else {
                symbol.setTypeSympol(TypeSympol.LETTER);
            }
            symbol.setSymbol(buf);
            composite.add(symbol);
        }
    }
}
