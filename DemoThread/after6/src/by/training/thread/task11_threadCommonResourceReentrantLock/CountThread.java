package by.training.thread.task11_threadCommonResourceReentrantLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class CountThread implements Runnable {
    CommonResource res;
    ReentrantLock locker;
    CountThread(CommonResource res, ReentrantLock lock) {
        this.res = res;
        locker = lock;
    }
    public void run() {
        locker.lock(); // устанавливаем блокировку
        try {
            res.x = 1;
            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(),

                        res.x);

                res.x++;
                TimeUnit.MICROSECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock(); // снимаем блокировку
        }
    }
}
