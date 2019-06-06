package by.training.thread.task19_executorServiceCallable.executorservice;

import java.util.ArrayDeque;

public class ProductList {
    private static ArrayDeque<String> arr = new ArrayDeque<String>() {
        {
            this.add("Product 1");
            this.add("Product 2");
            this.add("Product 3");
            this.add("Product 4");
            this.add("Product 5");
        }
    };
    public static String getProduct() {
        return arr.poll();
    }
}
