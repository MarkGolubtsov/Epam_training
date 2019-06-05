package by.traning.task02.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sentence implements  Composite {
    private List<Component> list = new ArrayList<>();
    @Override
    public String compose() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i).compose());
        }
        return  result.toString();
    }


    public void sort(final Comparator comparator) {
        list.sort(comparator);
    }

     public int  getCountSymbol(final char s) {
        int result = 0;
        for (Component buf : list) {
            Lexeme lexeme = (Lexeme) buf;
           result = result + lexeme.countSymbol(s);
        }
        return result;
    }
    @Override
    public void add(final Component component) {
        list.add(component);
    }

    public  Lexeme getLexem(final int index) {
        if (index < list.size()) {
         return (Lexeme) list.get(index);
        } else {
            return new Lexeme();
        }
    }

    @Override
    public Composite copy() {
        Sentence result = new Sentence();
        for (Component c
                : list) {
            result.add(c.copy());
        }
        return result;
    }
}
