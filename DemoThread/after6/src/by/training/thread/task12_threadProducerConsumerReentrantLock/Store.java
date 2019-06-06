package by.training.thread.task12_threadProducerConsumerReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

//Класс Склад, хранящий произведенные товары
class Store {
    private int product = 0;
    ReentrantLock locker;
    Condition condition;
    Store() {
        locker = new ReentrantLock(); // создаем блокировку
        condition = locker.newCondition(); // получаем условие, связанное с блокировкой
    }
    public void get() {
        locker.lock();
        try {
// пока нет доступных товаров на складе, ожидаем
            while (product < 1)
            condition.await();
            product--;
            System.out.println("Покупатель купил 1 товар");
            System.out.println("Товаров на складе: " + product);
// сигнализируем
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
    public void put() {
        locker.lock();
        try {
// пока на складе 3 товара, ждем освобождения места
            while (product >= 3)
            condition.await();
            product++;
            System.out.println("Производитель добавил 1 товар");
            System.out.println("Товаров на складе: " + product);
// сигнализируем
            condition.signalAll();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            locker.unlock();
        }
    }
}
//класс Производитель
class Producer implements Runnable{
    Store store;
    Producer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
//Класс Потребитель
class Consumer implements Runnable {
    Store store;
    Consumer(Store store) {
        this.store = store;
    }
    public void run() {
        for (int i = 1; i <6; i++) {
            store.get();
        }
    }
}
