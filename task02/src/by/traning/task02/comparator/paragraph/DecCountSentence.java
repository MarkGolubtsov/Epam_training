package by.traning.task02.comparator.paragraph;

import by.traning.task02.entity.Component;
import by.traning.task02.entity.Paragraph;

import java.util.Comparator;

public class DecCountSentence implements Comparator<Component> {
    @Override
    public int compare(final Component o1, final Component o2) {
        return  ((Paragraph) o2).counSentence() - ((Paragraph) o1).counSentence();

    }
}
