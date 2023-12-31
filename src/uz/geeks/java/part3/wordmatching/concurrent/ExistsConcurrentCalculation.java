package uz.geeks.java.part3.wordmatching.concurrent;

import uz.geeks.java.part3.wordmatching.task.ExistsTask;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExistsConcurrentCalculation {
    //
    public static boolean existWord(String word, List<String> dictionary) throws InterruptedException, ExecutionException {
        //
        int numCores = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numCores);

        int size = dictionary.size();
        int step = size / numCores;
        int startIndex, endIndex;
        List<ExistsTask> tasks = new ArrayList<>();

        for (int i = 0; i < numCores; i++) {
            startIndex = i * step;
            if (i == numCores - 1) {
                endIndex = dictionary.size();
            } else {
                endIndex = (i + 1) * step;
            }
            ExistsTask task = new ExistsTask(startIndex, endIndex, dictionary, word);
            tasks.add(task);
        }
        try {
            return executor.invokeAny(tasks);
        } catch (ExecutionException e) {
            if (e.getCause() instanceof NoSuchElementException)
                return false;
            throw e;
        } finally {
            executor.shutdown();
        }
    }
}
