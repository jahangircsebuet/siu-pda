package ProducerConsumer;

import java.util.Random;

public class Producer implements Runnable {
    private final static Random generator = new Random();
    private final Buffer sharedLocation;
    public Producer(Buffer sharedLocation) {
        this.sharedLocation = sharedLocation;
    }
    @Override
    public void run() {
        // store values 1 to 10 in sharedLocation
        int sum = 0;
        for (int count=0;count<10;count++) {
            try {
                Thread.sleep(generator.nextInt(3000));// random sleep
                sharedLocation.set(count);
                sum += count;
                System.out.println("sum: " + sum + "\n");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
