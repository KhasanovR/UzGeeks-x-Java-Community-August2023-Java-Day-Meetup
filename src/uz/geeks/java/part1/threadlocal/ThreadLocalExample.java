package uz.geeks.java.part1.threadlocal;

public class ThreadLocalExample {
    //
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //
        Runnable task = () -> {
            //
            int threadId = (int) Thread.currentThread().getId();
            threadLocal.set(threadId);
            System.out.println("Thread " + threadId + ": ThreadLocal value = " + threadLocal.get());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
