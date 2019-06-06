package by.training.thread.task10_threadProducer_Consumer_wait_notify;

 class ProducerConsumerApp {
    public static void main(String[] args) {
        Store store = new Store();
        new Producer(store).start();
        new Consumer(store).start();
/* Producer producer = new Producer(store);
Consumer consumer = new Consumer(store);
new Thread(producer).start();
new Thread(consumer).start();*/
    }
}
//Класс Склад, хранящий произведенные товары
class Store {
    private int product = 0;
    public synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
    public synchronized void get() {
        while (product <1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: "+ product);
        notify();
    }
}
//класс Производитель
class Producer extends Thread{//implements Runnable {
    Store store;
    Producer(Store store) {
        this.store = store;
    }
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
//Класс Потребитель
class Consumer extends Thread{//implements Runnable {
    Store store;
    Consumer(Store store) {
        this.store = store;
    }
    public void run() {
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}