package by.traning.task02.entity;


import by.traning.task02.enm.TypeSympol;

import java.util.ArrayList;

public class Lexeme implements Composite{

    private  ArrayList<Component> list = new ArrayList<>();

    private Composite word =new Word();

    public Component getWord() {
        return word;
    }

    public void setWord(Composite word) {
        this.word = word;
    }

    @Override
    public void add(Component component) {
//        Symbol symbol = (Symbol) component;
//        if (symbol.getTypeSympol()== TypeSympol.LETTER)
//        {
//            word.add(component);
//        }
//        else {
         list.add(component);
//        }
    }

    @Override
    public String compose() {
        String result="";
        //result = result+" "+word.compose();
        for (int i = 0; i <list.size(); i++) {
            result =result+list.get(i).compose();
        }
        return result;
    }

}
