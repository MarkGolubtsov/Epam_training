package by.bsuir.task3.thread;

import by.bsuir.task3.ent.Matrix;
import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;

public class FactoryThread {
    private static  final Logger LOGGER
            = Logger.getLogger(FactoryThread.class.getSimpleName());

    private int id;

    private Matrix matrix;

    private Semaphore sem;
    private FactoryThread() {
    id=1;
    sem = new Semaphore(1,true);
    }

    private static class LazySomethingHolder {

        public static FactoryThread singletonInstance = new FactoryThread();
    }

    public static FactoryThread getInstance() {

        return LazySomethingHolder.singletonInstance ;
    }

    public Thread createThread() {
        ThreadMatrix threadMatrix = new ThreadMatrix(matrix,id,sem);
        LOGGER.info("create Thread "+id);
        id=id+1;
        Thread thread  = new Thread(threadMatrix);
        return thread;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
}
