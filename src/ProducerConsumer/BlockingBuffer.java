package ProducerConsumer;

import java.util.concurrent.ArrayBlockingQueue;

// creating sync buffer using ArrayBlockingQueue
public class BlockingBuffer implements Buffer {
    private final ArrayBlockingQueue<Integer> buffer;// shared buffer
    public BlockingBuffer() {
        this.buffer = new ArrayBlockingQueue<>(1);// Handles sync automatically
    }
    @Override
    public void set(int value) throws InterruptedException {
        buffer.put(value);
        System.out.println("producer writes: " + value);
        System.out.println("Q size: " + buffer.size());
    }

    @Override
    public int get() throws InterruptedException {
        int readValue = buffer.take();
        System.out.println("consumer reads: " + readValue);
        System.out.println("Q size: " + buffer.size());
        return readValue;
    }
}
