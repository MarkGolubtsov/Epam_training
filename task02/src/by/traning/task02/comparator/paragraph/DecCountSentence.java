package by.traning.task02.comparator.paragraph;

import by.traning.task02.entity.Component;
import by.traning.task02.entity.Paragraph;
import by.traning.task02.entity.Sentence;
import by.traning.task02.validator.SentenceClassValid;

import java.util.Comparator;

public class DecCountSentence implements Comparator<Component> {
    @Override
    public int compare(Component o1, Component o2) {
            if (((Paragraph) o1).counSentence() == ((Paragraph) o2).counSentence()) {
                return 0;
            }
            if (((Paragraph) o1).counSentence() < ((Paragraph) o2).counSentence()) {
                return 1;
            } else {
                return -1;
            }

    }
}
