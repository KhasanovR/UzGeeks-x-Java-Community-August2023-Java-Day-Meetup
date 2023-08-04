package uz.geeks.java.fc.step3;

import java.util.concurrent.*;

public class Example3 {
    //
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //
        Callable<String> strRunnable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(5000);
                return "Process finished inside Runnable task...";
            }
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        long startTime = System.nanoTime();
        Future<String> futureResult = executorService.submit(strRunnable);

        while (!futureResult.isDone()) {
            System.out.println("I am waiting for future result...");
            Thread.sleep(800);

            double elapsedTime = (System.nanoTime() - startTime) / 1000000000.0;

            if (elapsedTime > 2) {
                System.out.println("I cannot wait anymore.....Bye.");
                futureResult.cancel(true);
            }
        }

        System.out.println(futureResult.get());
        System.out.println("Finally..... we are here....");
        executorService.shutdown();
    }
}

