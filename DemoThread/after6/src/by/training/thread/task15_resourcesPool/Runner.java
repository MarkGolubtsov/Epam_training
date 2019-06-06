package by.training.thread.task15_resourcesPool;

import java.util.LinkedList;

public class Runner {
    public static void main(String[] args) {
        LinkedList<AudioChannel> list = new LinkedList<AudioChannel>() {
            {
                this.add(new AudioChannel(1));
                this.add(new AudioChannel(2));
                this.add(new AudioChannel(3));
                this.add(new AudioChannel(4));
                this.add(new AudioChannel(5));
                this.add(new AudioChannel(6));
                this.add(new AudioChannel(7));
            }
        };
        ChannelPool<AudioChannel> pool = new ChannelPool<>(list);
        for (int i = 0; i < 20; i++) {
            new Client(pool).start();
        }
    }
}
