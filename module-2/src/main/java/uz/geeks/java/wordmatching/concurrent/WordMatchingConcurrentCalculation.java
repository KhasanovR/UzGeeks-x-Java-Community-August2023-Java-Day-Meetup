package uz.geeks.java.wordmatching.concurrent;

import uz.geeks.java.wordmatching.common.MatchData;
import uz.geeks.java.wordmatching.task.WordMatchingTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class WordMatchingConcurrentCalculation {

    public static MatchData getBestMatchingWords(String word, List<String> dictionary) throws InterruptedException, ExecutionException {

        int numCores = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(numCores);

        int size = dictionary.size();
        int step = size / numCores;
        int startIndex, endIndex;
        List<Future<MatchData>> results = new ArrayList<>();

        for (int i = 0; i < numCores; i++) {
            startIndex = i * step;
            if (i == numCores - 1) {
                endIndex = dictionary.size();
            } else {
                endIndex = (i + 1) * step;
            }
            WordMatchingTask task = new WordMatchingTask(startIndex, endIndex, dictionary, word);
            Future<MatchData> future = executor.submit(task);
            results.add(future);
        }

        executor.shutdown();

        List<String> words = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        for (Future<MatchData> future : results) {
            MatchData data = future.get();
            if (data.getDistance() < minDistance) {
                words.clear();
                minDistance = data.getDistance();
                words.addAll(data.getWords());
            } else if (data.getDistance() == minDistance) {
                words.addAll(data.getWords());
            }
        }

        MatchData result = new MatchData();
        result.setDistance(minDistance);
        result.setWords(words);
        return result;
    }

}
