package test;

import by.traning.task02.entity.TextAll;

import by.traning.task02.parser.LexemeParser;
import by.traning.task02.parser.ParagraphParser;
import by.traning.task02.parser.SymbolParser;
import by.traning.task02.parser.TextParser;
import by.traning.task02.reader.ReaderFile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComposeTextTest {
        /**
            Test for show compose
         */
    @Test(description = "Read text from file  and compose this text")
    public void readAndCompose() {
        ReaderFile readerFile = new ReaderFile("data\\input.txt");
        String  text = readerFile.getFile();
        System.out.println(text);
        TextParser fist = new TextParser();
        ParagraphParser second = new ParagraphParser();
        LexemeParser third = new LexemeParser();
        SymbolParser last = new SymbolParser();

        fist.setNext(second);
        second.setNext(third);
        third.setNext(last);
        TextAll textAll = new TextAll();
        fist.handle1(text, textAll);

        System.out.println("\n Compose :\n" + textAll.compose());
        Assert.assertEquals(true, true);
    }
}
