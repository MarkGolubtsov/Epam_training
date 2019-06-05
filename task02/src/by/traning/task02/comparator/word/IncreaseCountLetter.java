package by.traning.task02.comparator.word;

import by.traning.task02.entity.Component;
import by.traning.task02.entity.Lexeme;

import java.util.Comparator;

public class IncreaseCountLetter implements Comparator<Component> {
    @Override
    public int compare(final Component o1, final Component o2) {
        if (((Lexeme) o1).countLetter() == ((Lexeme) o2).countLetter()) {
            return 0;
        }
        if (((Lexeme) o1).countLetter() > ((Lexeme) o2).countLetter()) {
            return 1;
        } else {
            return -1;
        }
    }
}
