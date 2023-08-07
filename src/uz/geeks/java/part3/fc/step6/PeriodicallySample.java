package uz.geeks.java.part3.fc.step6;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class PeriodicallySample {
    //
    public static void main(String[] args) {
        //
        Runnable periodicTask = () -> System.out.println("Periodic task. Executed on: " + LocalDateTime.now());

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        executor.scheduleAtFixedRate(periodicTask, 0, 1, TimeUnit.SECONDS);
    }
}
