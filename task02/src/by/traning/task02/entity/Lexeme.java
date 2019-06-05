package by.traning.task02.entity;


import by.traning.task02.enm.TypeSympol;

import java.util.ArrayList;
import java.util.List;

public class Lexeme implements Composite {

    private List<Component> list = new ArrayList<>();

    private Composite word = new Word();

    private Component getWord() {
        return word;
    }

    @Override
    public void add(final Component component) {
       Symbol symbol = (Symbol) component;
       if (symbol.getTypeSympol() == TypeSympol.LETTER) {
           word.add(component);
       } else {
         list.add(component);
        }
    }

    protected void setWord(final Component w) {
        this.word = (Composite) w;
    }

    public  int countLetter() {
        Word w = (Word) getWord();
        return w.getSize();
    }

    public int countSymbol(final char symbol) {
     int result = 0;

        for (Component symbol1: list) {
            Symbol s = (Symbol) symbol1;
            if (symbol == s.getSymbol().charValue()) {
                result = result + 1;
            }
        }
        result = result + ((Word) word).countSymbolInWord(symbol);
        return result;
    }

    @Override
    public String compose() {
        StringBuilder result = new StringBuilder();
        result.append(" " + word.compose());
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i).compose());
        }
        return result.toString();
    }

    private Component copyWord() {
        return word.copy();
    }

    @Override
    public Composite copy() {
        Lexeme result = new Lexeme();
        for (Component c
                : list) {
            result.add(c.copy());
        }
        result.setWord(copyWord());
        return result;
    }

}
