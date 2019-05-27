package by.traning.task02;



import by.traning.task02.comparator.DecCountSentence;
import by.traning.task02.entity.TextAll;
import by.traning.task02.parser.LexemeParser;
import by.traning.task02.parser.ParagraphParser;
import by.traning.task02.parser.SymbolParser;
import by.traning.task02.parser.TextParser;
import by.traning.task02.reader.ReaderFile;
import org.apache.log4j.Logger;


public class Main {
    private static  final Logger logger = Logger.getLogger(TextAll.class.getSimpleName());
    public static void main(String[] args)  {
        String  text = ReaderFile.getFile("D:\\EPAM_JAVA\\TASK\\task02\\data\\text.txt");
        TextParser fist = new TextParser();
        ParagraphParser second = new ParagraphParser();
        LexemeParser third = new LexemeParser();
        SymbolParser last = new SymbolParser();

        fist.setNext(second);
        second.setNext(third);
        third.setNext(last);
        TextAll textAll= new TextAll();
        fist.handle1(text,textAll);
        System.out.println(textAll.compose());
        textAll.sortCountSentenseInParagraph(new DecCountSentence());
        System.out.println(textAll.compose());
    }



}
