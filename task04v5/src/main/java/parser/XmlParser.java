package parser;

import java.util.List;

public interface XmlParser<T> {
    List<T> getData(String path) throws ParserException;
}
