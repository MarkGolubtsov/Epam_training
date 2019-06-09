package by.bsuir.task3.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderThread {
    private String path;

    public void setPath(String path){
        this.path = path;
    }

    public int getCount()
    {
        int result;
        List<String> lines = new ArrayList<>();
        try (Stream<String> lineStream = Files.newBufferedReader(Paths.get(path)).lines()) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException ignored) {
        }
        result = Integer.parseInt(lines.get(0).trim());

        return result;
    }
}
