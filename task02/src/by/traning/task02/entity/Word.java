package by.traning.task02.entity;

import java.util.ArrayList;
import java.util.List;

public class Word implements Composite {

    private List<Component> list = new ArrayList<>();
    @Override
    public String compose() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i).compose());
        }
        return result.toString();
    }
    public int getSize() {
        return list.size();
    }
    @Override
    public void add(final Component component) {
        list.add(component);
    }

    public int countSymbolInWord(final char symbol) {
        int result = 0;
        for (Component symbol1
                : list) {
            Symbol s = (Symbol) symbol1;
            if (symbol == s.getSymbol().charValue()) {
                result = result + 1;
            }
        }
        return result;
    }

    @Override
    public Composite copy() {
        Word result = new Word();
        for (Component c
                : list) {
            result.add(c.copy());
        }

        return result;
    }
}
