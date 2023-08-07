package uz.geeks.java.extension;

public class Main {
    //
    public static void main(String[] args) {
        //
        ThreadExample threadExample = new ThreadExample();

        Thread thread = new Thread(threadExample);

        thread.start();
    }
}