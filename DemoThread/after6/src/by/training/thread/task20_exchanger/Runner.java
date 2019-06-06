package by.training.thread.task20_exchanger;

import java.util.concurrent.Exchanger;

public class Runner {
    private static int n = 3;
    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger();
        for (int i = 1; i <= n; i++) {
            Thread t1 = new Thread(new PutThread(ex));
            Thread t2 = new Thread(new GetThread(ex));

            t1.setName("Поток Put " + i);
            t2.setName("Поток Get " + i);

            t1.start();
            t2.start();

            /*try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }
    }
}
