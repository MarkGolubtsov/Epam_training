package by.training.task04.parser;

import by.training.task04.entity.Flower;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SAXParser implements XmlParser<Flower> {

    private static  SAXParser ourInstance = new SAXParser();

    public static  SAXParser getInstance() {
        return ourInstance;
    }

    private SAXParser() {
    }


    @Override
    public List<Flower> getData(String path) throws ParserException {
        try {

            SAXParserFactory factoryParser = SAXParserFactory.newInstance();
            javax.xml.parsers.SAXParser parser = factoryParser.newSAXParser();
            SAXFlowerHandler handler = new SAXFlowerHandler();
            File file = new File(path);
            parser.parse(file, handler);
            return handler.getFlowers();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new ParserException("", e);
        }
    }
}
