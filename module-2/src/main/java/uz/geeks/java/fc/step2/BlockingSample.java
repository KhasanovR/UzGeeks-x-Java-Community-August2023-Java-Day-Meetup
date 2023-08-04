package uz.geeks.java.fc.step2;

import java.util.concurrent.*;

public class BlockingSample {
    //

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //
        Callable<String> strRunnable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "Process finished inside Runnable task...";
            }
        };


        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> futureResult = executorService.submit(strRunnable);

        while (!futureResult.isDone()) {
            System.out.println("I am waiting for future result...");
            Thread.sleep(800);
        }

        System.out.println(futureResult.get());
        System.out.println("Finally..... we are here....");
        executorService.shutdown();
    }
}
