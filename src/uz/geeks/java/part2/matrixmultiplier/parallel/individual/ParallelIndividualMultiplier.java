package uz.geeks.java.part2.matrixmultiplier.parallel.individual;

import java.util.ArrayList;
import java.util.List;

public class ParallelIndividualMultiplier {
    //
    public static void multiply(double[][] matrix1, double[][] matrix2, double[][] result) {
        //
        List<Thread> threads = new ArrayList<>();

        int rowLengthOfMatrix1 = matrix1.length;
        int columnLengthOfMatrix2 = matrix2[0].length;

        for (int i = 0; i < rowLengthOfMatrix1; i++) {
            for (int j = 0; j < columnLengthOfMatrix2; j++) {
                IndividualMultiplierTask task = new IndividualMultiplierTask(result, matrix1, matrix2, i, j);
                Thread thread = new Thread(task);
                thread.start();
                threads.add(thread);

                if (threads.size() % 10 == 0) {
                    waitForThreads(threads);
                }
            }
        }
    }

    private static void waitForThreads(List<Thread> threads) {
        //
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
