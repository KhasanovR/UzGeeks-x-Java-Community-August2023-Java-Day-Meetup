package uz.geeks.java.priority;

public class Main {
    //
    public static void main(String[] args) {
        //
        PriorityThreadExample threadExample = new PriorityThreadExample();

        Thread thread1 = new Thread(threadExample);
        Thread thread2 = new Thread(threadExample);
        Thread thread3 = new Thread(threadExample);

        thread1.setPriority(Thread.MIN_PRIORITY);   // Set lowest priority (1)
        thread2.setPriority(Thread.NORM_PRIORITY);  // Set default priority (5)
        thread3.setPriority(Thread.MAX_PRIORITY);   // Set highest priority (10)

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
