package uz.geeks.java.part1.join;

public class JoinThreadExample implements Runnable {
    //
    @Override
    public void run() {
        //
        System.out.println("Thread " + Thread.currentThread().getId() + " started.");

        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second to simulate some work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Thread " + Thread.currentThread().getId() + " finished.");
    }
}
