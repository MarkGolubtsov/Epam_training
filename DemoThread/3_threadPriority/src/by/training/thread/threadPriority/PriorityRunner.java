package by.training.thread.threadPriority;

public class PriorityRunner {

    public static void main(String[] args)
    {
    PriorThread min = new PriorThread("min");
    PriorThread max = new PriorThread("max");
    PriorThread norm= new PriorThread("Norm");
    min.setPriority(Thread.MIN_PRIORITY);
    max.setPriority(Thread.MAX_PRIORITY);
    norm.setPriority(Thread.MAX_PRIORITY);
    min.start();
    norm.start();
    max.start();
    }
}
