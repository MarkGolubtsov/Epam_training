package by.training.thread.task06_threadCommonResource;

import java.util.concurrent.TimeUnit;

public class ThreadsApp {
    public static void main(String[] arg)
    {
        CommonReasours commonReasours = new CommonReasours();
        for (int i = 1; i < 6; i++) {
        Thread  t = new Thread(new CountThread(commonReasours));
        t.start();
        }

    }
}
class CommonReasours{
    int x=0;
}
class CountThread implements Runnable{
    CommonReasours res;

    public  CountThread(CommonReasours res)
    {
        this.res=res;
    }
    @Override
    public void run() {
        synchronized (res) {
            res.x = 1;

            for (int i = 1; i < 5; i++) {
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                try {
                    TimeUnit.MICROSECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}