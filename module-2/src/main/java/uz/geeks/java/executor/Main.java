package uz.geeks.java.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    //
    public static void main(String[] args) {
        //
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("Hello " + threadName);
        });
        executor.shutdown();
    }
}
