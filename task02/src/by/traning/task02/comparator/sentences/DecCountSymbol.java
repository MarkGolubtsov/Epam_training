package by.traning.task02.comparator.sentences;

import by.traning.task02.entity.Component;
import by.traning.task02.entity.Sentence;

import java.util.Comparator;

public class DecCountSymbol implements Comparator<Component> {

    private  char symbol;
    public DecCountSymbol(char s)
    {
        symbol = s;
    }
    @Override
    public int compare(Component o1, Component o2) {
        if (((Sentence) o1).getCountSymbol(symbol) == ((Sentence) o2).getCountSymbol(symbol)) {
            return 0;
        }
        if (((Sentence) o1).getCountSymbol(symbol) < ((Sentence) o2).getCountSymbol(symbol)) {
            return 1;
        } else {
            return -1;
        }
    }
}
