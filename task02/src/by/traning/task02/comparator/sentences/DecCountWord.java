package by.traning.task02.comparator.sentences;

import by.traning.task02.entity.Lexeme;

import java.util.Comparator;

public class DecCountWord implements Comparator<Lexeme> {
    @Override
    public int compare(Lexeme o1, Lexeme o2) {
        if (((Lexeme) o1).getSizeWord() == ((Lexeme) o2).getSizeWord()) {
            return 0;
        }
        if (((Lexeme) o1).getSizeWord() < ((Lexeme) o2).getSizeWord()) {
            return 1;
        } else {
            return -1;
        }
    }
}
