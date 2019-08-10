package action.user;

import action.role.ajax.AuthorizeActionAjax;
import action.role.forward.AuthorizeActionForward;
import controller.MainServlet;
import domain.User;
import exception.DBException;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

@MultipartConfig(maxFileSize=1024*1024*5)
public class UpdateUserImg extends AuthorizeActionForward {
    private  static String UPLOADS;
    static {
        try {
            UPLOADS = Paths.get(UpdateUserImg.class.getResource("/user").toURI()).toAbsolutePath().toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Forward exec(HttpServletRequest request, HttpServletResponse response) throws DBException, ServletException, IOException {
        User user =getAuthorizedUser();
        String name ="img"+user.getId();
        user.setImg(name);
        save(request,name);
        UserService userService = factory.getService(UserService.class);
        userService.update(user);
        return new Forward("/shop/user/edit");
    }
    private void save(HttpServletRequest req,String name) throws ServletException, IOException {
        Part filePart = req.getPart("file");
        File uploads = new File(UPLOADS+"\\"+name);
        try (InputStream input = filePart.getInputStream()) {
            Files.copy(input, uploads.toPath());
        } catch (IOException e) {

        }
    }
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //проверяем является ли полученный запрос multipart/form-data
//        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
//        if (!isMultipart) {
//            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
//            return;
//        }
//
//        // Создаём класс фабрику
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//
//        // Максимальный буфера данных в байтах,
//        // при его привышении данные начнут записываться на диск во временную директорию
//        // устанавливаем один мегабайт
//        factory.setSizeThreshold(1024*1024);
//
//        // устанавливаем временную директорию
//        File tempDir = (File)getServletContext().getAttribute("javax.servlet.context.tempdir");
//        factory.setRepository(tempDir);
//
//        //Создаём сам загрузчик
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//        //максимальный размер данных который разрешено загружать в байтах
//        //по умолчанию -1, без ограничений. Устанавливаем 10 мегабайт.
//        upload.setSizeMax(1024 * 1024 * 10);
//
//        try {
//            List items = upload.parseRequest(request);
//            Iterator iter = items.iterator();
//
//            while (iter.hasNext()) {
//                FileItem item = (FileItem) iter.next();
//
//                if (item.isFormField()) {
//                    //если принимаемая часть данных является полем формы
//                    processFormField(item);
//                } else {
//                    //в противном случае рассматриваем как файл
//                    processUploadedFile(item);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//            return;
//        }
//    }
//
//    /**
//     * Сохраняет файл на сервере, в папке upload.
//     * Сама папка должна быть уже создана.
//     *
//     * @param item
//     * @throws Exception
//     */
//    private void processUploadedFile(FileItem item) throws Exception {
//        File uploadetFile = null;
//        //выбираем файлу имя пока не найдём свободное
//        do{
//            String path = getServletContext().getRealPath("/upload/"+random.nextInt() + item.getName());
//            uploadetFile = new File(path);
//        }while(uploadetFile.exists());
//
//        //создаём файл
//        uploadetFile.createNewFile();
//        //записываем в него данные
//        item.write(uploadetFile);
//    }
//
//    /**
//     * Выводит на консоль имя параметра и значение
//     * @param item
//     */
//    private void processFormField(FileItem item) {
//        System.out.println(item.getFieldName()+"="+item.getString());
//    }

}
