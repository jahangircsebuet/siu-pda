package ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedBufferTest {
    public static void main(String[] args) {
        ExecutorService application = Executors.newCachedThreadPool();
        // create synchronized buffer to store ints
        SynchronizedBuffer sharedLocation = new SynchronizedBuffer();
        application.execute(new Producer(sharedLocation));
        application.execute(new Consumer(sharedLocation));
        application.shutdown();
    }
}
