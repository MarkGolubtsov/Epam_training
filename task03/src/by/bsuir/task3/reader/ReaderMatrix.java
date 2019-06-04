package by.bsuir.task3.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderMatrix {

    private String path;

    public void setPath(String path){
        this.path = path;
    }

    public  int[][] createMatrix()
    {
    int[][] result;
        List<String> lines = new ArrayList<>();
        try (Stream<String> lineStream = Files.newBufferedReader(Paths.get(path)).lines()) {

            lines = lineStream.collect(Collectors.toList());

        } catch (IOException ignored) {
        }

        result = new int[lines.size()][lines.size()];
        for (int i = 0; i <lines.size() ; i++) {
            String[] buf =lines.get(i).split(" ");
            for (int j = 0; j <buf.length ; j++) {
                result[i][j]=Integer.parseInt(buf[j]);
            }
        }
        return  result;
    }
}
