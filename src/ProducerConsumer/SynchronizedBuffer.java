package ProducerConsumer;

public class SynchronizedBuffer implements Buffer {
    private int buffer = -1;
    private boolean occupied = false;
    @Override
    public synchronized void set(int value) throws InterruptedException {
        while (occupied) {
            System.out.println("producer tries to write");
            System.out.println("buffer full, producer waits");
            wait();
        }
        buffer = value;
        // indicates producer can not store another value
        // until consumer receives current buffer value
        occupied = true;
        System.out.println("producer writes buffer: " + value);
    }

    @Override
    public synchronized int get() throws InterruptedException {
        while (!occupied) {
            System.out.println("consumer tries to read");
            System.out.println("buffer empty, consumer waits");
            wait();
        }
        occupied = false;
        System.out.println("consumer reads buffer: " + buffer);
        notifyAll();// tells all the waiting threads to enter runnable state
        return buffer;
    }
}
