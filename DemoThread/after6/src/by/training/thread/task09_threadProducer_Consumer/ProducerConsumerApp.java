package by.training.thread.task09_threadProducer_Consumer;

import java.util.concurrent.TimeUnit;

public class ProducerConsumerApp {
    public static void main(String[] args) {
        Store store = new Store();
        new Producer(store).start();
        new Consumer(store).start();
    }
}
//создаем объект склада, с которого будут брать товары покупатели
//и куда будут вносить товары производители
class Store {
    int counter = 0; // счетчик товаров
    final int N = 5; // максимально допустимое число
    // синхронизированный метод для производителей
    synchronized int put() {
        if(counter<=N) //если товаров меньше
        {
            counter++; // кладем товар
            System.out.println ("склад имеет " + counter + "товар(ов)");
            return 1; // в случае удачного выполнения возвращаем 1
        }
        return 0;// в случае неудачного выполнения возвращаем 0
    }
    // метод для покупателей
    synchronized int get() {
        if(counter>0) //если хоть один товар присутствует
        {
            counter--; //берем товар
            System.out.println ("склад имеет " + counter + " товар(ов)");
            return 1;// в случае удачного выполнения возвращаем 1
        }
        return 0;// в случае неудачного выполнения возвращаем 0
    }
}
//поток производителя
class Producer extends Thread {
    Store store; // объект склада, куда кладем товар
    int product = 5; // количество товаров, которые надо добавить

    Producer(Store store) {
        this.store = store;
    }

    public void run() {
        try {
            while (product > 0) { // пока у производителя имеются товары
                product = product - store.put(); // кладем один товар на склад
                System.out.println("производителю осталось произвести " + product + " товар(ов)");

                TimeUnit.MILLISECONDS.sleep(100);// время простоя
            }

        } catch (InterruptedException e) {
            System.out.println("поток производителя прерван");
        }
    }
}
    class Consumer extends Thread {
        Store store; // объект склада, с которого покупатель будет брать товар
        int product = 0; // текущее количество товаров со склада
        Consumer(Store store) {
            this.store = store;
        }
        public void run() {
            try {
                while (product < 5) {// пока количество товаров не будет равно 5
                    product = product + store.get(); // берем по одному товару со склада
                    System.out.println("Потребитель купил " + product +"товар(ов)");

                    TimeUnit.MILLISECONDS.sleep(100);
                }
            } catch (InterruptedException e) {
                System.out.println("поток потребителя прерван");
            }
        }
    }