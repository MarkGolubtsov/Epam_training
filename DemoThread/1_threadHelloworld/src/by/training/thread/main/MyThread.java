package by.training.thread.main;

public class MyThread extends Thread {
    public  void run()
    {
        System.out.println("Hello word!");
    }
    public static void main(String[] args)
    {
        MyThread t = new MyThread();
        t.run();
    }
}
