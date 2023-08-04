package uz.geeks.java.fc.step1;

import java.util.concurrent.*;

public class Example1 {
    //
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //
        Callable<String> strRunnable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "Process finished inside Runnable task...";
            }
        };


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> result = executorService.submit(strRunnable);
        System.out.println(result.get());
        executorService.shutdown();
    }
}
