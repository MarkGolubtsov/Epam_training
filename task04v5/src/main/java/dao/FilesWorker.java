package dao;

import controller.Controller;
import org.xml.sax.SAXException;
import validators.Validator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesWorker {

    private  static String UPLOADS;
    static {
        try {
            UPLOADS = Paths.get(FilesWorker.class.getResource("/upload").toURI()).toAbsolutePath().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    String NAME_UPLOAD="sxema2.xml";

    public void save(HttpServletRequest req) throws IOException, ServletException {
        for (File myFile : new File(UPLOADS).listFiles())
            if (myFile.isFile()) myFile.delete();

        Part filePart = req.getPart("file");
        File uploads = new File(UPLOADS+"\\"+NAME_UPLOAD);
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, uploads.toPath());
        } catch (IOException e) {

        }
    }

    public String getPathFile() {
        return UPLOADS+"\\"+NAME_UPLOAD;
    }


    public boolean isCorrectFile() {
        Path pathXSD = null;
        try {
            pathXSD = Paths.get(FilesWorker.class.getResource("/sxemaXSD.xsd").toURI()).toAbsolutePath();
        } catch (URISyntaxException e) {
        }

        boolean flag=false;
        try {
            flag= Validator.validateXMLByXSD( new File(getPathFile()),new File(pathXSD.toString()));
        } catch (SAXException e) {
        }
        catch (IOException e) {
        }
        return flag;
    }

    public  String getCorrectFilePath() {
        boolean flag = isCorrectFile();
        if (!flag)
        {
            Path pathXML = null;
            try {
                pathXML = Paths.get(Controller.class.getResource("/sxema.xml").toURI()).toAbsolutePath();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
            return   pathXML.toString();
        }
        return getPathFile();
    }
}
