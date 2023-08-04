package uz.geeks.java.wordmatching.task;

import uz.geeks.java.wordmatching.distance.LevenshteinDistance;
import uz.geeks.java.wordmatching.exception.WordNotExistException;

import java.util.List;
import java.util.concurrent.Callable;

public class ExistsTask implements Callable<Boolean> {
    //
    private final int startIndex;
    private final int endIndex;
    private final List<String> dictionary;
    private final String word;

    public ExistsTask(int startIndex, int endIndex, List<String> dictionary, String word) {
        //
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.dictionary = dictionary;
        this.word = word;
    }

    @Override
    public Boolean call() throws WordNotExistException {
        //
        for (int i = startIndex; i < endIndex; i++) {
            if (LevenshteinDistance.calculate(word, dictionary.get(i)) == 0) {
                return true;
            }
            if (Thread.interrupted()) {
                return false;
            }
        }
        throw new WordNotExistException("The word " + word + " doesn't exists.");
    }
}
