package by.training.thread.task14_diningPhilosophers;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Philosopher extends Thread {
    Semaphore semaphore;
    int numDinner = 0;
    int id;

    Philosopher(Semaphore sem, int identifier) {
        semaphore = sem;
        id = identifier;
    }

    @Override
    public void run() {
        try {
            while (numDinner < 3) {
                semaphore.acquire();
                System.out.println("Philosopher " + id + " seat");
                TimeUnit.MILLISECONDS.sleep(500);
                numDinner++;
                System.out.println("Philosopher " + id + " stand");
                semaphore.release();
                TimeUnit.MILLISECONDS.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
