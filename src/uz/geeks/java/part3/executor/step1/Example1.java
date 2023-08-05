package uz.geeks.java.part3.executor.step1;

import java.util.concurrent.TimeUnit;

public class Example1 {
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

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
