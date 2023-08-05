package uz.geeks.java.part3.executor.step3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example3 {
    //
    public static void main(String[] args) {
        //
        Runnable runnable = () -> {
            try {
                String name = Thread.currentThread().getName();
                System.out.println("Hello " + name);
                TimeUnit.SECONDS.sleep(5);
                System.out.println("Bye " + name);
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(runnable);

        try {
            System.out.println("Attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(3, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("Tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("Cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("Shutdown finished");
        }
    }
}
