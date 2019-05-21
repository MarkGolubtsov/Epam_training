package by.traning.task2.entity;

import java.util.ArrayList;
import java.util.LinkedList;

public class Sentence {

    private ArrayList<Lexeme> lexemes = new ArrayList<>();

    public void  addLexem(Lexeme l)
    {
        lexemes.add(l);
    }

}
