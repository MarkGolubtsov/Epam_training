package parser;


import entity.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class DOMParser implements XmlParser<Flower> {

    private static DOMParser ourInstance;
    private DocumentBuilder documentBuilder;

    static {
      ///
        try {
            ourInstance = new DOMParser();
        } catch (ParserException e) {
            e.printStackTrace();
        }

    }
    public static DOMParser getInstance() {
        return ourInstance;
    }

    private DOMParser() throws ParserException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new ParserException("Error in initialize DOM Parser" + e);
        }
    }

    @Override
    public List<Flower> getData(String path) throws ParserException {
        List<Flower> flowers = new ArrayList<>();
        Document document;
        try {
            document = documentBuilder.parse(path);
            Element element = document.getDocumentElement();
            NodeList flowerList = element.getElementsByTagName("flower");
            //logger.debug("Start DOM parsing");
            for (int i = 0; i < flowerList.getLength(); i++) {
                Element flowerElement = (Element) flowerList.item(i);
                Flower flower = buildFlower(flowerElement);
                flowers.add(flower);
            }
        } catch (SAXException | IOException e) {
            throw new ParserException();
        }
        return flowers;
    }

    private Flower buildFlower(Element element) {
        Flower flower = new Flower();
        flower.setName(getElementTextContent(element,"name"));
        flower.setOrigin(getElementTextContent(element,"origin"));
        String soil= getElementTextContent(element,"soil");
        String color=getElementTextContent(element,"color");
        int size = Integer.valueOf(getElementTextContent(element,"size"));
        Visual visual = new Visual(color,size);
        flower.setVisual(visual);
        boolean lighting = Boolean.valueOf(getElementTextContent(element,"lighting"));
        int watering = Integer.valueOf(getElementTextContent(element,"watering"));
        double temperature = Double.valueOf(getElementTextContent(element,"temperature"));
        GrowingTips growingTips= new GrowingTips(temperature,lighting,watering);
        flower.setGrowingTips(growingTips);
        flower.setSoil(Soil.of(soil));
        String multiplying = getElementTextContent(element,"multiplying");
        flower.setMultiplying(Multiplying.of(multiplying));
        return flower;
    }

    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        //logger.debug("Add to  " + text);
        return text;
    }
        public static void main(String[] args) throws URISyntaxException, ParserException {
        DOMParser domParser = DOMParser.getInstance();
        List<Flower> post = domParser.getData("D:\\EPAM_JAVA\\TASK\\task04\\src\\by\\training\\task04\\data\\sxema.xml");
        post.forEach(System.out::println);
    }

}
