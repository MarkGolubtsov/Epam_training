package by.traning.task2.reader;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFile {
    private static  final Logger logger = Logger.getLogger(ReaderFile.class.getSimpleName());

    public static String getFile(String path)
    {
        String  result="";
        try (BufferedReader br = new BufferedReader(new FileReader(path)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null) {
                result = result +" "+ sCurrentLine;
            }

        } catch (IOException e) {
        }
        logger.info("Read File "+path);
        return result;
    }


}
