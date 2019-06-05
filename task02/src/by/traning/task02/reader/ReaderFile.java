package by.traning.task02.reader;



import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;


public class ReaderFile {
    private static  final Logger LOGGER
            = Logger.getLogger(ReaderFile.class.getSimpleName());
    private String path;
    public ReaderFile(final String p) {
        path = p;
    }
    public  String getFile() {
        String result = "";
        byte[] res = new byte[0];
        try (FileInputStream fin = new FileInputStream(path)) {
            res = fin.readAllBytes();
        } catch (IOException ex) {
            LOGGER.error("Exception with file");
        }
        for (int j = 0; j < res.length; j++) {
            result = result + (char) res[j];
        }
        LOGGER.info("Read File " + path);
        result.replace("\r", "");
        return result;
    }


}
