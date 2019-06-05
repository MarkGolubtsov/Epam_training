package by.traning.task02.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Paragraph implements Composite {

    private List<Component> list = new ArrayList<>();
    @Override
    public String compose() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i).compose());
        }
        return  result.append("    ").toString();
    }



    @Override
    public void add(final Component component) {
        list.add(component);
    }

    public int counSentence() {
        return list.size();
    }

    public void sortSentence(final Comparator comparator) {
        list.sort(comparator);
    }
    public Sentence getSentence(final int i) {
        if (i < list.size()) {
            return (Sentence) list.get(i);
        } else {
            return new Sentence();
        }
    }

    @Override
    public Composite copy() {
        Paragraph result = new Paragraph();
        for (Component c
                : list) {
            result.add(c.copy());
        }
        return result;
    }
}
