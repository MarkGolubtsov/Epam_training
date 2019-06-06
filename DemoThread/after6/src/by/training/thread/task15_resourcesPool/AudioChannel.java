package by.training.thread.task15_resourcesPool;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AudioChannel {
    private int channellId;
    public AudioChannel(int id) {
        super();
        channellId = id;
    }

    public int getChannellId() {
        return channellId;
    }

    public void setChannellId(int channellId) {
        this.channellId = channellId;
    }

    public void using() {
        try {
            TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
