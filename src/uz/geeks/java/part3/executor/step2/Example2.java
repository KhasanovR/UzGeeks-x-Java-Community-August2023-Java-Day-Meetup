package uz.geeks.java.part3.executor.step2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example2 {
    //
    public static void main(String[] args) {
        //
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Hello " + name);
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Bye " + name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(runnable);
        executor.shutdown();
    }
}
