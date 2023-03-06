package ProducerConsumer;

public class UnsynchronizdBuffer implements Buffer {
    private int buffer = -1;//shared by prod consumer threads
    public void set(int value) throws InterruptedException {
        System.out.printf("Producer writes: " + value + "\n");
        buffer = value;
    }

    public int get() throws InterruptedException {
        System.out.printf("Consumer reads: " + buffer + "\n");
        return buffer;
    }
}
