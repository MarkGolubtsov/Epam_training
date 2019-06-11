package by.bsuir.task3.dao;

import by.bsuir.task3.exc.SizeCountException;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class FileDao implements Dao {

    private static final FileDao INSTANCE = new FileDao();
    private FileDao() {
    }
    @Override
    public int[][] readMatrix(final String path) throws SizeCountException {
        List<String> lines = new ArrayList<>();
        try (Stream<String> lineStream
                     = Files.newBufferedReader(Paths.get(path)).lines()) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException ignored) {
            throw new SizeCountException("problem with file!");
        }
        int[][]  result = new int[lines.size()][];
            for (int i = 0; i < lines.size(); i++) {
                String[] buf = lines.get(i).split("\\s+");
                result[i] = new int[buf.length];
                for (int j = 0; j < buf.length; j++) {
                    result[i][j] = Integer.parseInt(buf[j]);
                }
            }
            return result;

    }

    @Override
    public void saveMatrix(final String path, final int[][] matrix)
            throws IOException {
        BufferedWriter writer
                = new BufferedWriter(new FileWriter(new File(path)));
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                writer.write(String.valueOf(matrix[i][j]));
                writer.write(" ");
            }
            writer.write("\r\n");
        }
        writer.flush();
    }

    @Override
    public int countThread(final String path)  throws SizeCountException {
        int result;
        List<String> lines = new ArrayList<>();
        try (Stream<String> lineStream
                     = Files.newBufferedReader(Paths.get(path)).lines()) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException ignored) {
            throw  new SizeCountException("problem with file for Thread");
        }
        result = Integer.parseInt(lines.get(0).trim());

        return result;
    }
    public static FileDao getInstance() {
        return INSTANCE;
    }
}
