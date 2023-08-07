package uz.geeks.java.part1.runnable;

public class Main {
    //
    public static void main(String[] args) {
        //
        //ThreadExample threadExample = new ThreadExample();
    Runnable runnable = () -> {
        // LOGIC

        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getId() + ": " + i);
        }
    };
        Thread thread = new Thread(runnable);

        thread.start();
    }
}