package parser;

import entity.*;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StAXParser implements XmlParser<Flower> {
    private static StAXParser ourInstance = new StAXParser();
    public static StAXParser getInstance() {
        return ourInstance;
    }
    private XMLInputFactory inputFactory;
    private List<Flower> flowers = new ArrayList<>();
    private StAXParser() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public List<Flower> getData(String path) throws ParserException {
        flowers.clear();
        FileInputStream inputStream;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = new FileInputStream(new File(path));
            reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamReader.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals("flower")) {
                        Flower flower = buildFlower(reader);
                       // logger.debug("Add " + flower.toString());
                        flowers.add(flower);

                    }
                }

            }
        } catch (FileNotFoundException e) {
            throw new ParserException();
        } catch (XMLStreamException e) {
            throw new ParserException("" + e);
        }

        return flowers;
    }

    private Flower buildFlower(XMLStreamReader reader) throws XMLStreamException, ParserException {
        Flower flower = new Flower();
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case "name":
                            flower.setName(getXMLText(reader));
                            break;
                        case "soil":
                            flower.setSoil(Soil.of(getXMLText(reader)));
                            break;
                        case "origin":
                            flower.setOrigin(getXMLText(reader));
                            break;
                        case "id":
                            flower.setID(getXMLText(reader));
                            break;
                        case "multiplying":
                            flower.setMultiplying(Multiplying.of(getXMLText(reader)));
                            break;
                        case "visual-paremeters":
                            flower.setVisual(getXMLVisual(reader));
                            break;
                        case "growing-tips":
                            flower.setGrowingTips(getXMLGrowingTips(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals("flower")) {
                        return flower;
                    }
                    break;
            }


        }


        throw new ParserException("Unknown element in flower");
    }




    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        //logger.debug("Add data to " + text);

        return text;
    }
    private Visual getXMLVisual(XMLStreamReader reader) throws XMLStreamException, ParserException {
        String color ="";
        int size=0;
        String name;
        int type;
        Visual visual;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case "size":
                            size=Integer.valueOf(getXMLText(reader));
                            break;
                        case "color":
                            color=getXMLText(reader);
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals("visual-paremeters")) {
                       visual=new Visual(color,size);
                        return visual;
                    }
                    break;
            }
        }
        throw new ParserException("Unknown element in visual");

    }
    private GrowingTips getXMLGrowingTips(XMLStreamReader reader) throws XMLStreamException, ParserException {
        boolean lighting = false;
        int watering=0;
        double temperature=0.0;
        String name;
        int type;
        GrowingTips growingTips;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (name) {
                        case "lighting":
                            lighting=Boolean.valueOf(getXMLText(reader));
                            break;
                        case "watering":
                            watering=Integer.valueOf(getXMLText(reader));
                            break;
                        case "temperature":
                            temperature=Double.valueOf(getXMLText(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (name.equals("growing-tips")) {
                        growingTips=new GrowingTips(temperature,lighting,watering);
                        return growingTips;
                    }
                    break;
            }
        }
        throw new ParserException("Unknown element in visual");
    }

}
