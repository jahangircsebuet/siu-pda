package ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CircularBufferTest {
    public static void main(String[] args) {
        // create new thread pool
        ExecutorService application = Executors.newCachedThreadPool();
        // bounded buffer, here size 3
        CircularBuffer sharedLocation = new CircularBuffer();
        application.execute(new Producer(sharedLocation));
        application.execute(new Consumer(sharedLocation));
        application.shutdown();
    }
}
