package by.traning.task02.entity;

import java.util.ArrayList;

public class Word implements Composite {

    private ArrayList<Component> list = new ArrayList<>();
    @Override
    public String compose() {
        StringBuilder result =new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i).compose());
        }
        return result.toString();
    }
    public int getSize()
    {
        return list.size();
    }
    @Override
    public void add(Component component) {
        list.add(component);
    }

    public int countSymbolInWord(char symbol)
    {
        int result=0;

        for (Component symbol1: list) {
            Symbol s=(Symbol) symbol1;
            if (symbol==s.getSymbol().charValue())
            {
                result=result+1;
            }
        }

        return result;
    }
}
