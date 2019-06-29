package parser;

import controller.Controller;
import entity.*;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SAXParser implements XmlParser<Flower> {

    private final static Logger logger = Logger.getLogger(SAXParser.class);
    private static  SAXParser ourInstance = new SAXParser();

    public static  SAXParser getInstance() {
        return ourInstance;
    }

    private SAXParser() {
    }


    @Override
    public List<Flower> getData(String path) throws ParserException {
        try {
            logger.info("start SAX");
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
