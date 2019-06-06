package by.training.thread.task17_auction;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Bid extends Thread {
    private Integer bidId;
    private int price;
    private CyclicBarrier barrier;

    public Bid(int id, int price, CyclicBarrier bar) {
        this.bidId = id;
        this.barrier = bar;
        this.price = price;
    }

    public Integer getBidId() {
        return bidId;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public void run() {
        try {
            System.out.println("Client " + bidId + " specifies price");
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(300));
            int delta = new Random().nextInt(50);
            price += delta;
            System.out.println("Bid " + bidId + " : " + price);
            barrier.await();
            System.out.println("Continue to work...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
