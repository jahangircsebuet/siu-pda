package ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UnsynchronizedBufferTest {
    public static void main(String[] args) {
        // application with 2 threads manipulating with unsync buffer
        ExecutorService application = Executors.newCachedThreadPool();
        // create unsync buffer to store ints
        Buffer sharedLocation = new UnsynchronizdBuffer();
        application.execute(new Producer(sharedLocation));
        application.execute(new Consumer(sharedLocation));
        application.shutdown();// terminate application when tasks complete
    }
}
