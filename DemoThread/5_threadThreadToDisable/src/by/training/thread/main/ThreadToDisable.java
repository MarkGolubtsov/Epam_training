package by.training.thread.main;

import java.util.concurrent.TimeUnit;

public class ThreadToDisable implements Runnable {

    private  boolean isActive;
    void  disable(){
        isActive=false;
    }
    ThreadToDisable()
    {
        isActive=true;
    }
    @Override
    public void run() {
        System.out.println("Поток"+Thread.currentThread().getName()+"начал работу...\n");
        int counter=1;
        while (isActive)
        {
            System.out.println("Цикл"+counter++);
            try {
                TimeUnit.MICROSECONDS.sleep(21);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Поток прерван");
            }
        }
        System.out.println("Поток"+Thread.currentThread().getName()+"завершил...\n");
    }
}
