package by.traning.task02.entity;


import by.traning.task02.enm.TypeSympol;

import java.util.ArrayList;

public class Lexeme implements Composite{

    private  ArrayList<Component> list = new ArrayList<>();

    private Composite word =new Word();

    private Component getWord() {
        return word;
    }

    @Override
    public void add(Component component) {
       Symbol symbol = (Symbol) component;
       if (symbol.getTypeSympol()== TypeSympol.LETTER)
       {
           word.add(component);
       }
       else {
         list.add(component);
        }
    }
    
    public  int getSizeWord(){
        Word word =(Word) getWord();
        return word.getSize();
    }
    public int countSymbol(char symbol)
    {
     int result=0;

        for (Component symbol1: list) {
            Symbol s=(Symbol) symbol1;
            if (symbol==s.getSymbol().charValue())
            {
                result=result+1;
            }
        }
        result= result+((Word) word).countSymbolInWord(symbol);
        return result;
    }

    @Override
    public String compose() {
        StringBuilder result=new StringBuilder();
        result.append(" "+word.compose());
        for (int i = 0; i <list.size(); i++) {
            result.append(list.get(i).compose());
        }
        return result.toString();
    }

}
