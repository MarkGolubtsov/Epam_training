package by.training.thread.task17_auction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.CyclicBarrier;

public class Auction {
    private ArrayList<Bid> bids;
    private CyclicBarrier barrier;
    public final int BIDS_NUMBER = 5;
    public Auction() {
        bids = new ArrayList<>();
        barrier = new CyclicBarrier(BIDS_NUMBER, () -> {
            Bid winner = Auction.this.defineWinner();
            System.out.println("Bid " + winner.getBidId() + ", price: " + winner.getPrice() + " win!");
        });
    }
    public CyclicBarrier getBarrier() {
        return barrier;
    }
    public boolean add(Bid e) {
        return bids.add(e);
    }
    public Bid defineWinner() {
        return Collections.max(bids, Comparator.comparingInt(Bid::getPrice));
    }
}
