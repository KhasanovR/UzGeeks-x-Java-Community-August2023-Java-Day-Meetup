package uz.geeks.java.part2.matrixmultiplier.parallel.group;

import java.util.ArrayList;
import java.util.List;

public class ParallelGroupMultiplier {
    //
    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        //
        List<Thread> threads = new ArrayList<>();

        int rowLengthOfMatrix1 = matrix1.length;

        int numThreads = Runtime.getRuntime().availableProcessors();
        int step = rowLengthOfMatrix1 / numThreads;
        int startIndex = 0;
        int endIndex = step;

        for (int i = 0; i < numThreads; i++) {
            GroupMultiplierTask task = new GroupMultiplierTask(result, matrix1, matrix2, startIndex, endIndex);
            Thread thread = new Thread(task);
            thread.start();
            threads.add(thread);
            startIndex = endIndex;
            endIndex = i == numThreads - 2 ? rowLengthOfMatrix1 : endIndex + step;
        }

        waitForThreads(threads);
    }

    private static void waitForThreads(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threads.clear();
    }
}
