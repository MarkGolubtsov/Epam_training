package by.traning.task02.entity;


import java.util.ArrayList;
import java.util.Comparator;

public class TextAll implements Composite{

    private  ArrayList<Component> list = new ArrayList<>();

    @Override
    public String compose() {
        StringBuilder result = new StringBuilder() ;
        result.append("   ");
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i).compose()+"\n   ");
        }
        return result.toString();
    }

    @Override
    public void add(Component component) {
        list.add(component);
    }

    public void sortCountSentenseInParagraph(Comparator comparator)
    {
        list.sort(comparator);
    }

    public Paragraph getParagrapg(int i)
    {
        if (i<list.size())
        {
            return (Paragraph ) list.get(i);
        }
        else
        {
            return new Paragraph();
        }
    }
}
