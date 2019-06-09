package by.bsuir.task3;

import by.bsuir.task3.controller.FactoryThread;
import by.bsuir.task3.ent.Matrix;
import by.bsuir.task3.reader.ReaderMatrix;
import by.bsuir.task3.reader.ReaderThread;
import org.apache.log4j.Logger;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {

    private static  final Logger LOGGER
            = Logger.getLogger(Main.class.getSimpleName());
    public static void main(String[] args) throws InterruptedException {
        ReaderMatrix readerMatrix= new ReaderMatrix();
        readerMatrix.setPath("data\\input.txt");

        int[][] buf = readerMatrix.createMatrix();

        for (int i = 0; i <buf.length; i++) {
            for (int j = 0; j <buf[i].length ; j++) {
                if (buf[i][j]<10)
                System.out.print("  "+buf[i][j]);
                else System.out.print(" "+buf[i][j]);
            }
            System.out.println();
        }
        Matrix matrix = new Matrix(buf);

        ReaderThread readerThread = new ReaderThread();
        readerThread.setPath("data\\countThread");
        int countThread = readerThread.getCount();


        FactoryThread factoryThread = FactoryThread.getInstance();
        factoryThread.setMatrix(matrix);

        CopyOnWriteArrayList<Thread> list= new CopyOnWriteArrayList<>();
        Thread thread;
        for (int i = 0; i <countThread ; i++) {
            list.add(factoryThread.createThread());
        }
        for (Thread t:
             list) {
            t.start();
        }
        list.get(list.size()-1).join();

        System.out.println();
        factoryThread.getMatrix();
        for (int i = 0; i <factoryThread.getMatrix().getMatrix().length; i++) {
            for (int j = 0; j <(factoryThread.getMatrix().getMatrix())[i].length ; j++) {
                if (buf[i][j]<10)
                    System.out.print("  "+buf[i][j]);
                else System.out.print(" "+buf[i][j]);
            }
            System.out.println();
        }
        LOGGER.info("end");
    }
}
