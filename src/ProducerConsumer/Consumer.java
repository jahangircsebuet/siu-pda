package ProducerConsumer;

import java.util.Random;

public class Consumer implements Runnable {
    private final static Random generator = new Random();
    private final Buffer sharedLocation;

    public Consumer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }
    @Override
    public void run() {
        // read sharedLocations value 10 times and add into variable sum
        int sum = 0;
        for (int count=0;count<10;count++) {
            try {
                Thread.sleep(generator.nextInt(3000));
                sum += sharedLocation.get();
                System.out.println("sum: " + sum + "\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
