package by.traning.task02.comparator.sentences;

import by.traning.task02.entity.Component;
import by.traning.task02.entity.Sentence;

import java.util.Comparator;

public class IncreaseCountSymbol  implements Comparator<Component> {

    private  char symbol;
    public IncreaseCountSymbol(final char s) {
        symbol = s;
    }
    @Override
    public int compare(final  Component o1, final  Component o2) {
        if (((Sentence) o1).getCountSymbol(symbol)
                == ((Sentence) o2).getCountSymbol(symbol)) {
            return 0;
        }
        if (((Sentence) o1).getCountSymbol(symbol)
                > ((Sentence) o2).getCountSymbol(symbol)) {
            return 1;
        } else {
            return -1;
        }
    }
}
