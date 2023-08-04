package examples.daemon;

public class DaemonThreadExample {
    //
    public static void main(String[] args) {
        //
        Thread daemonThread = new Thread(() -> {
            //
            while (true) {
                System.out.println("DaemonThread: I'm running in the background.");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();

        System.out.println("Main Thread: I'm the main thread.");
    }
}
