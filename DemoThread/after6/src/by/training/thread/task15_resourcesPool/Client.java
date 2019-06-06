package by.training.thread.task15_resourcesPool;

public class Client extends Thread {
    private boolean reading = false;
    private ChannelPool<AudioChannel> pool;
    public Client(ChannelPool<AudioChannel> audioPool) {
        pool = audioPool;
    }

    @Override
    public void run() {
        AudioChannel channel = null;
        try {
            channel = pool.gerResuorce(500);
            reading = true;
            System.out.println("Channel client #" + getId() + " took channel #" + channel.getChannellId());
            channel.using();
        } catch (ResourceException e) {
            System.out.println("Client #" + getId() + " lost ->" + e.getMessage());
        } finally {
            if (channel != null) {
                reading = false;
                System.out.println("Channel client #" + getId() + " : " + channel.getChannellId() + " channel released");
                pool.returnResource(channel);
            }
        }
    }
    public boolean isReading() {
        return reading;
    }
}
