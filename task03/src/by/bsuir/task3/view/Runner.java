package by.bsuir.task3.view;


import by.bsuir.task3.controller.Commands;
import by.bsuir.task3.controller.Controller;
import by.bsuir.task3.dao.FileDao;
import by.bsuir.task3.exc.MatrixException;
import by.bsuir.task3.exc.SizeCountException;
import by.bsuir.task3.service.MatrixService;
import by.bsuir.task3.service.ServiceFactory;

import java.util.Scanner;

public class Runner {
    private static final String DIR="data\\";
    public static void main(String[] args) throws SizeCountException, MatrixException {

        Scanner in = new Scanner(System.in);
        Controller controller = new Controller();
        System.out.println(Commands.INITIAL.toString());
        System.out.println(Commands.PRINT.toString());
        System.out.println(Commands.RUN.toString());
        System.out.println(Commands.SAVE.toString());
        System.out.println("EXIT");
        boolean flag= true;

        while (flag)
        {
            System.out.println("Write command and data");
            String[] req = new String[2];
            req[0]=in.next();
            if("EXIT".equals(req[0])) {
                break;
            }
            if (!"PRINT".equals(req[0]))
            {
                System.out.println("file:");
                req[1]=DIR+in.next();
            }else {
                req[1]=" ";
            }

            int res = controller.command(req);
            if (res==-1)
            {
                System.out.println("Some problems");
            }

        }

    }
}
