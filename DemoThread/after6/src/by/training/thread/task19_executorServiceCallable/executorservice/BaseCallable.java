package by.training.thread.task19_executorServiceCallable.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class BaseCallable implements Callable<String> {
    private static int index = 0;
    @Override
    public String call() throws Exception {
        String product = ProductList.getProduct();
        index++;
        String result;
        if (product != null) {
            result = product + " done";
        } else {
            result = "productList is empty";
        }
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(index + " : " + result);
        return result;
    }
}
