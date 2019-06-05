package by.traning.task02.entity;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TextAll implements Composite {

    private List<Component> list = new ArrayList<>();

    @Override
    public String compose() {
        StringBuilder result = new StringBuilder();
        result.append("   ");
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i).compose() + "\n   ");
        }
        return result.toString();
    }


    @Override
    public void add(final Component component) {
        list.add(component);
    }

    public void sortCountSentenseInParagraph(final Comparator comparator) {
        list.sort(comparator);
    }

    public Paragraph getParagrapg(final int i) {
        if (i < list.size()) {
            return (Paragraph) list.get(i);
        } else {
            return new Paragraph();
        }
    }

    @Override
    public Composite copy() {
        TextAll result = new TextAll();
        for (Component c
                : list) {
            result.add(c.copy());
        }
        return result;
    }

}
