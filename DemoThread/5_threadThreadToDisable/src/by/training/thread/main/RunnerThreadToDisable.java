package by.training.thread.main;

import java.util.concurrent.TimeUnit;

public class RunnerThreadToDisable  {
    public static void main(String[] args)  {
        System.out.println("Главный начал работать");
        ThreadToDisable mythread= new ThreadToDisable();
        Thread myT = new Thread(mythread,"name of Thread");
        myT.start();

        try {
            TimeUnit.SECONDS.sleep(1);
            //TODO
           // Thread.interrupted(mythread);
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Главный поток завершил работу...");
    }
}
