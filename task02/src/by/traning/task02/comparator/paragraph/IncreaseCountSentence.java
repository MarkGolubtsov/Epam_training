package by.traning.task02.comparator.paragraph;

import by.traning.task02.entity.Component;
import by.traning.task02.entity.Paragraph;

import java.util.Comparator;

public class IncreaseCountSentence implements Comparator<Component> {
    @Override
    public int compare(final Component o1, final  Component o2) {
            return  ((Paragraph) o1).counSentence() - ((Paragraph) o2).counSentence();
    }
}
