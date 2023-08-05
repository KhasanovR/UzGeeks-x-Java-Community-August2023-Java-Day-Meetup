package uz.geeks.java.part1.synchronization;

public class Main {
    //
    public static void main(String[] args) {
        //
        Counter counter = new Counter();
        SynchronizedThreadExample threadExample = new SynchronizedThreadExample(counter);

        Thread thread1 = new Thread(threadExample);
        Thread thread2 = new Thread(threadExample);

        thread1.start();
        thread2.start();
    }
}
