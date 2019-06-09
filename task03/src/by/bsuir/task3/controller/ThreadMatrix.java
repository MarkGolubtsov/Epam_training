package by.bsuir.task3.controller;

import by.bsuir.task3.Main;
import by.bsuir.task3.ent.Matrix;
import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ThreadMatrix  implements Runnable{
    private static  final Logger LOGGER
            = Logger.getLogger(ThreadMatrix.class.getSimpleName());

    private  Matrix matrix;

    private int id;

    private Semaphore sem;

    public  ThreadMatrix(Matrix matrix,final int id,final Semaphore sem) {
        this.id = id;
        this.matrix=matrix;
        this.sem=sem;
    }

    @Override
    public void run() {
         int[][] mat=matrix.getMatrix();
         while (matrix.isRepeatChange())
            for (int i = 0; i < mat.length; i++) {
                try {
                    sem.acquire();
                    if (matrix.getMatrix()[i][i]==0) {
                        matrix.changeElementOnDiagonal(i, id);
                        LOGGER.info(i + " element change ");
                    }
                    else {
                        LOGGER.info(i + " element not change");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    sem.release();
                   try {
                       TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }


            }

    }
}
