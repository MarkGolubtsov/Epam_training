package by.traning.task02.reader;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class ReaderFile {
    private static  final Logger logger = Logger.getLogger(ReaderFile.class.getSimpleName());

    public static String getFile(String path)
    {
        String result = "";
        byte[] res = new byte[0];
        try(FileInputStream fin=new FileInputStream(path))
        {
           logger.info("File size: %d bytes \n"+fin.available());

            res= fin.readAllBytes();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        for (int j = 0; j <res.length ; j++) {
            result=result+(char)res[j];
        }
        logger.info("Read File "+path);
        return result;
    }


}
