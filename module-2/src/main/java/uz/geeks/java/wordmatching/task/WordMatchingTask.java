package uz.geeks.java.wordmatching.task;

import uz.geeks.java.wordmatching.common.MatchData;
import uz.geeks.java.wordmatching.distance.LevenshteinDistance;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class WordMatchingTask implements Callable<MatchData> {
    //
    private final int startIndex;
    private final int endIndex;
    private final List<String> dictionary;
    private final String word;

    public WordMatchingTask(int startIndex, int endIndex, List<String> dictionary, String word) {
        //
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.dictionary = dictionary;
        this.word = word;
    }

    @Override
    public MatchData call() {
        //
        List<String> results = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        int distance;
        for (int i = startIndex; i < endIndex; i++) {
            distance = LevenshteinDistance.calculate(word, dictionary.get(i));
            if (distance < minDistance) {
                results.clear();
                minDistance = distance;
                results.add(dictionary.get(i));
            } else if (distance == minDistance) {
                results.add(dictionary.get(i));
            }
        }

        MatchData result = new MatchData();
        result.setWords(results);
        result.setDistance(minDistance);
        return result;
    }

}
