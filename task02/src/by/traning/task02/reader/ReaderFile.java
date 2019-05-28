package by.traning.task02.reader;



import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class ReaderFile {
    private static  final Logger logger = Logger.getLogger(ReaderFile.class.getSimpleName());

    public static String getFile(String path)
    {
        String result = "";
        byte[] res = new byte[0];
        try(FileInputStream fin=new FileInputStream(path))
        {
            res= fin.readAllBytes();
        }
        catch(IOException ex){

            logger.error("Exception with file");
        }
        for (int j = 0; j <res.length ; j++) {
            result=result+(char)res[j];
        }
        logger.info("Read File "+path);
        result.replace("\r","");
        return result;
    }


}
