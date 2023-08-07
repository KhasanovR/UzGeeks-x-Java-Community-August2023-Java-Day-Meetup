package uz.geeks.java.part3.fc.step5;

import java.time.LocalDateTime;
import java.util.concurrent.*;


public class ScheduledSample {
    //
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //
        Callable<String> scheduledTask = () -> "Result of scheduled task. Executed on: " + LocalDateTime.now();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        System.out.println("Task scheduled to execute after 5 seconds at : " + LocalDateTime.now());

        Future<String> result = executor.schedule(scheduledTask, 5, TimeUnit.SECONDS);

        System.out.println(result.get());

        executor.shutdown();
    }
}
