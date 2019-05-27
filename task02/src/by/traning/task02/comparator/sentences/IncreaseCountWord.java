package by.traning.task02.comparator.sentences;

import by.traning.task02.entity.Component;
import by.traning.task02.entity.Lexeme;
import by.traning.task02.entity.Sentence;

import java.util.Comparator;

public class IncreaseCountWord implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
        if (((Lexeme) o1).getSizeWord() == ((Lexeme) o2).getSizeWord()) {
            return 0;
        }
        if (((Lexeme) o1).getSizeWord() > ((Lexeme) o2).getSizeWord()) {
            return 1;
        } else {
            return -1;
        }
    }
}
