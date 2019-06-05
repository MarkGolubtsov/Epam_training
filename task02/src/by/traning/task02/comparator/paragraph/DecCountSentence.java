package by.traning.task02.comparator.paragraph;

import by.traning.task02.entity.Component;
import by.traning.task02.entity.Paragraph;

import java.util.Comparator;

public class DecCountSentence implements Comparator<Component> {
    @Override
    public int compare(final Component o1, final Component o2) {
            if (((Paragraph) o1).counSentence()
                    == ((Paragraph) o2).counSentence()) {
                return 0;
            }
            if (((Paragraph) o1).counSentence()
                    < ((Paragraph) o2).counSentence()) {
                return 1;
            } else {
                return -1;
            }

    }
}
