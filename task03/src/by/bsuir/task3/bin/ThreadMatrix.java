package by.bsuir.task3.bin;

import org.apache.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ThreadMatrix  implements Runnable {
    private static final Logger LOGGER
            = Logger.getLogger(ThreadMatrix.class.getSimpleName());

    private Matrix matrix;

    private int id;

    private Semaphore sem;

    public ThreadMatrix(final Matrix m,
                        final int i,
                        final Semaphore s) {
        this.id = i;
        this.matrix = m;
        this.sem = s;
    }

    @Override
    public void run() {
        while (matrix.isRepeatChange()) {
            try {
                sem.acquire();
                int i = matrix.getCurrent();
                if ((i < matrix.getMatrix().length)) {
                    if ((matrix.getMatrix()[i][i] == 0)) {
                        matrix.changeElementOnDiagonal(i, id);
                        LOGGER.info(i + " element change ");
                        matrix.setCurrent(i + 1);
                    } else {
                        LOGGER.info(i + " element not change");
                    }
                }
            } catch (InterruptedException e) {
                LOGGER.error("problem Semaphore");
            } finally {
                sem.release();
               try {
                    TimeUnit.MILLISECONDS.sleep(5);
               } catch (InterruptedException e) {
                    LOGGER.error("problem sleep");
               }

            }


        }
    }
}
