package uz.geeks.java.part1.runnable;

public class ThreadExample implements Runnable {
    //
    @Override
    public void run() {
        //
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
        }
    }
}
