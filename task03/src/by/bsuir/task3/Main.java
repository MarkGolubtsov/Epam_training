package by.bsuir.task3;

import by.bsuir.task3.controller.FactoryThread;
import by.bsuir.task3.ent.Matrix;
import by.bsuir.task3.reader.ReaderMatrix;
import org.apache.log4j.Logger;

public class Main {

    private static  final Logger LOGGER
            = Logger.getLogger(Main.class.getSimpleName());
    public static void main(String[] args) throws InterruptedException {
        ReaderMatrix readerMatrix= new ReaderMatrix();
        readerMatrix.setPath("data\\input.txt");

        int[][] buf = readerMatrix.createMatrix();

        for (int i = 0; i <buf.length; i++) {
            for (int j = 0; j <buf[i].length ; j++) {
                System.out.print(" "+buf[i][j]);
            }
            System.out.println();
        }
        Matrix matrix = new Matrix(buf);
        FactoryThread factoryThread = FactoryThread.getInstance();
        factoryThread.setMatrix(matrix);

        Thread thread= factoryThread.createThread();
        thread.start();
        Thread thread2= factoryThread.createThread();
        thread2.start();
        Thread thread3= factoryThread.createThread();
        thread3.start();
        thread.join();
        thread2.join();
        thread3.join();
        System.out.println();
        factoryThread.getMatrix();
        for (int i = 0; i <factoryThread.getMatrix().getMatrix().length; i++) {
            for (int j = 0; j <(factoryThread.getMatrix().getMatrix())[i].length ; j++) {
                System.out.print(" "+buf[i][j]);
            }
            System.out.println();
        }
    }
}
