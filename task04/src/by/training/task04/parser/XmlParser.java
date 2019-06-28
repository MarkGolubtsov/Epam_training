package by.training.task04.parser;

import java.util.List;

public interface XmlParser<T> {
    List<T> getData(String path) throws ParserException;
}
