package parser;

import entity.*;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;

public class SAXFlowerHandler extends DefaultHandler {

    private final static Logger logger = Logger.getLogger(SAXFlowerHandler.class);
    private List<Flower> flowers = new ArrayList<>();
    private Flower flower;
    private String content;

    private String color;
    private int size;

    private double temperature;
    private boolean isLikeLighting;
    private int watering;

    @Override
    public void startDocument() throws SAXException {

        flowers.clear();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equals("flower")) {
            flower = new Flower();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case "flower":
                logger.debug("Add " +flower.toString());
                flowers.add(flower);
                break;
            case "name":
                logger.debug("Add " + content);
                flower.setName(content);
                break;
            case "soil":
               logger.debug("Add " + content);
                flower.setSoil(Soil.of(content));
                break;
            case "multiplying":
            {
                logger.debug("Add " + content);
                flower.setMultiplying(Multiplying.of(content));
                break;
            }
            case "origin":
                logger.debug("Add " + content);
                flower.setOrigin(content);
                break;
            case "color":
                //logger.debug("Add " + content);
               color=content;
                break;
            case "size":
                //logger.debug("Add " + content);
                size=Integer.valueOf(content);
                break;
            case "visual-paremeters":
                Visual visual = new Visual(color,size);
                //logger.debug("Add " + year);
                flower.setVisual(visual);
                break;
            case "id":
                flower.setID(content);
                break;
            case "lighting":
               logger.debug("Set light" + isLikeLighting);
                isLikeLighting = Boolean.valueOf(content);
                break;
            case "watering":
                logger.debug("Set watering" + watering);
               watering = Integer.valueOf(content);
                break;

            case "growing-tips":
                logger.debug("Set growing-tips" + content);
                GrowingTips growingTips = new GrowingTips(temperature,isLikeLighting,watering);
                flower.setGrowingTips(growingTips);
                break;
            case "temperature":
                temperature=Double.valueOf(content);
                break;
            case "flowers":
                break;
            default:
                throw new SAXException();

        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }


    public List<Flower> getFlowers() {
        return flowers;
    }
}
