package ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockingBufferTest {
    public static void main(String[] args) {
        ExecutorService application = Executors.newCachedThreadPool();
        // create blocking buffer to store ints
        Buffer sharedLocation = new BlockingBuffer();
        application.execute(new Producer(sharedLocation));
        application.execute(new Consumer(sharedLocation));
        application.shutdown();
    }
}
