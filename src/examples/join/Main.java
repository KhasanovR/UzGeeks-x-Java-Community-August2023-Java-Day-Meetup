package examples.join;

public class Main {
    //
    public static void main(String[] args) {
        //
        JoinThreadExample threadExample = new JoinThreadExample();

        Thread thread1 = new Thread(threadExample);
        Thread thread2 = new Thread(threadExample);

        thread1.start();
        try {
            thread1.join(); // Wait for thread1 to finish before starting thread2
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
    }
}
