package by.training.thread.task19_executorServiceCallable.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class CalcCallable implements Callable<Number> {
    @Override
    public Number call() throws Exception {
        Number res = new Random().nextGaussian();
        return res;
    }
}
