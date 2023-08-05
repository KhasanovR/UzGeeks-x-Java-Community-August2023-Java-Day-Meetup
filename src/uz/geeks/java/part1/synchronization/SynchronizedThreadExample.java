package uz.geeks.java.part1.synchronization;

public class SynchronizedThreadExample implements Runnable {
    //
    private Counter counter;

    public SynchronizedThreadExample(Counter counter) {
        //
        this.counter = counter;
    }

    @Override
    public void run() {
        //
        for (int i = 1; i <= 5; i++) {
            counter.increment();
            System.out.println("Thread " + Thread.currentThread().getId() + ": Count = " + counter.getCount());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
