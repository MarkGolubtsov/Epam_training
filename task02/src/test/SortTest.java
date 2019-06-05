package test;

import by.traning.task02.comparator.paragraph.IncreaseCountSentence;
import by.traning.task02.comparator.sentences.IncreaseCountSymbol;
import by.traning.task02.comparator.word.IncreaseCountLetter;
import by.traning.task02.entity.Paragraph;
import by.traning.task02.entity.Sentence;
import by.traning.task02.entity.TextAll;
import by.traning.task02.parser.LexemeParser;
import by.traning.task02.parser.ParagraphParser;
import by.traning.task02.parser.SymbolParser;
import by.traning.task02.parser.TextParser;
import by.traning.task02.reader.ReaderFile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest {

    private TextAll textAll;
    public   void  createData() {
        ReaderFile readerFile = new ReaderFile("data\\text.txt");
        String  text = readerFile.getFile();
        TextParser fist = new TextParser();
        ParagraphParser second = new ParagraphParser();
        LexemeParser third = new LexemeParser();
        SymbolParser last = new SymbolParser();

        fist.setNext(second);
        second.setNext(third);
        third.setNext(last);
        textAll = new TextAll();
        fist.handle1(text, textAll);
    }

    @Test(description = "Test sort paragraph(count sentense)")
    public void  sortParagraph() {
        createData();
        System.out.println(textAll.compose());
        TextAll copy = (TextAll) textAll.copy();
        copy.sortCountSentenseInParagraph(new IncreaseCountSentence());
        System.out.println(copy.compose());
        Paragraph paragraph1 = copy.getParagrapg(0);
        Paragraph paragraph2 = copy.getParagrapg(1);
        boolean actual = paragraph1.counSentence() < paragraph2.counSentence();
        boolean expected = true;
        Assert.assertEquals(actual, expected);
    }
    @Test(description = "Sort words by word length")
    public void sortWord() {
        createData();
        Sentence sentence = textAll.getParagrapg(0).getSentence(0);
        Sentence copy = (Sentence) sentence.copy();
        System.out.println(sentence.compose());
        copy.sort(new IncreaseCountLetter());
        System.out.println(sentence.compose());
        boolean actual = copy.getLexem(0).countLetter()
                < copy.getLexem(1).countLetter();
        boolean expected = true;
        Assert.assertEquals(actual, expected);

    }
    @Test(description = "sorting sentences by"
            + " the number of occurrence of the back character")
    public  void sortSentence() {
        char symbol = 'o';
        createData();
        Paragraph paragraph = textAll.getParagrapg(0);
        System.out.println(paragraph.compose());
        Paragraph copy = (Paragraph) paragraph.copy();
        copy.sortSentence(new IncreaseCountSymbol(symbol));
        System.out.println(copy.compose());
        boolean actual
                = copy.getSentence(0).getCountSymbol(symbol)
                < copy.getSentence(1).getCountSymbol(symbol);
        boolean expected = true;
        Assert.assertEquals(actual, expected);

    }
}
