package ProducerConsumer;

public class CircularBuffer implements Buffer {
    private final int[] buffer = {-1, -1, -1};
    private int occupiedCells = 0;
    private int writeIndex = 0;// producer starts writing from index 0
    private int readIndex = 0;// consumer starts reading from index 0
    @Override
    public synchronized void set(int value) throws InterruptedException {
        while (occupiedCells == buffer.length) {
            System.out.println("buffer is full, producer waits\n");
            wait();
        }
        buffer[writeIndex] = value;
        System.out.println("producer writeIndex: " + writeIndex);
        // display buffer contents
        for (int item: buffer) {
            System.out.print(item + " ");
        }
        System.out.println("\n");
        // update circular write index
        writeIndex = (writeIndex + 1) % buffer.length;
        ++occupiedCells;
        System.out.println("producer writes: " + value);
        System.out.println("occupiedCells: " + occupiedCells);
        notifyAll();// notify threads waiting to read from buffer
    }

    @Override
    public synchronized int get() throws InterruptedException {
        while (occupiedCells == 0) {
            System.out.println("buffer empty, consumer waits\n");
            wait();
        }
        int readValue = buffer[readIndex];
        System.out.println("consumer readIndex: " + readIndex);
        readIndex = (readIndex + 1) % buffer.length;
        System.out.println("consumer reads: " + readValue);
        --occupiedCells;
        System.out.println("occupiedCells: " + occupiedCells);
        // display buffer contents
        for (int item: buffer) {
            System.out.print(item + " ");
//            System.out.println(item + " ");
        }
        System.out.println("\n");
        notifyAll();
        return readValue;
    }
}
