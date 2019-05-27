package by.traning.task02.validator;

import by.traning.task02.entity.Sentence;

public class SentenceClassValid {
    public static boolean isSentense(Object o)
    {
        return Sentence.class.equals(o.getClass());
    }
}
