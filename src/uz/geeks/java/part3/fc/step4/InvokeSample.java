package uz.geeks.java.part3.fc.step4;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class InvokeSample {
    //
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<String> sleepingTaskA = () -> {
            TimeUnit.SECONDS.sleep(2);
            return "Result of sleepingTaskA";
        };

        Callable<String> sleepingTaskB = () -> {
            TimeUnit.SECONDS.sleep(1);
            return "Result of sleepingTaskB";
        };

        Callable<String> sleepingTaskC = () -> {
            TimeUnit.SECONDS.sleep(5);
            return "Result of sleepingTaskC";
        };

        List<Callable<String>> tasks = Arrays.asList(sleepingTaskA, sleepingTaskB, sleepingTaskC);
        long startTime = System.nanoTime();

        String futures = executorService.invokeAny(tasks);
        //String result = executorService
        double elapsedTime = (System.nanoTime() - startTime) / 1000000000.0;
        System.out.println(elapsedTime);


        executorService.shutdown();
    }
}
