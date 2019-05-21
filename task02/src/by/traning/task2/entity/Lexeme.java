package by.traning.task2.entity;

import java.util.ArrayList;
import java.util.LinkedList;

public class Lexeme {

  private ArrayList<Symbol> symbols = new ArrayList<>();
  private String word;

  public void addSymbol(Symbol s)
  {
      symbols.add(s);
  }

    public String getWord() {
        return word;
    }

}
