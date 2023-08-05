package uz.geeks.java.part3.fc.step3;

import java.util.concurrent.*;

public class FutureCancelSample {
    //
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //
        Callable<String> strRunnable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(6);
                return "[Process finished inside Runnable task]";
            }
        };

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        long startTime = System.nanoTime();
        Future<String> futureResult = executorService.submit(strRunnable);

        while (!futureResult.isDone()) {
            System.out.println("I am waiting for future result...");
            TimeUnit.SECONDS.sleep(1);

            double elapsedTime = (System.nanoTime() - startTime) / 1000000000.0;

            if (elapsedTime > 6) {
                System.out.println("I cannot wait anymore.....Bye.");
                futureResult.cancel(true);
            }
        }

        if (futureResult.isCancelled()) {
            System.out.println("Task has been canceled.");
        }
        else {
            System.out.println(futureResult.get());
            System.out.println("Finally..... we are here....");
        }

        executorService.shutdown();
    }
}

