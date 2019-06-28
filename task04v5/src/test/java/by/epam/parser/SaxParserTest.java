package by.epam.parser;

import entity.*;
import org.junit.Assert;
import parser.DOMParser;
import parser.ParserException;
import parser.SAXParser;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SaxParserTest {

    @org.junit.Test
    public void getData() throws URISyntaxException, ParserException {
       SAXParser parser = SAXParser.getInstance();
        Path path = Paths.get(SaxParserTest.class.getResource("/sxema.xml").toURI()).toAbsolutePath();
        List<Flower> list = parser.getData(path.toString());
        Flower flower = new Flower();
        Flower flower1 = new Flower();
        flower.setID("asd123");
        flower1.setID("asd124");
        flower.setName("Mark");
        flower1.setName("Mark2");

        flower.setSoil(Soil.GROUND);
        flower1.setSoil(Soil.GROUND);

        flower.setOrigin("Minsk");
        flower1.setOrigin("Minsk");

        flower.setMultiplying(Multiplying.SEEDS);
        flower1.setMultiplying(Multiplying.SEEDS);

        flower.setVisual(new Visual("Red",120));
        flower1.setVisual(new Visual("Red",120));

        flower.setGrowingTips(new GrowingTips(23.5,true,30));
        flower1.setGrowingTips(new GrowingTips(23.5,true,30));

        List<Flower> list1 = new ArrayList<>();
        list1.add(flower);
        list1.add(flower1);
        Assert.assertEquals(list, list1);
    }
}
