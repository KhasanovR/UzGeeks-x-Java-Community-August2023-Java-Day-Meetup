package uz.geeks.java.wordmatching.main;

import uz.geeks.java.wordmatching.common.MatchData;
import uz.geeks.java.wordmatching.concurrent.WordMatchingConcurrentCalculation;
import uz.geeks.java.wordmatching.data.WordsLoader;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;


public class WordMatchingConcurrentMain {
    //
    public static void main(String[] args) {
        //
        try {
            Date startTime;
            Date endTime;

            var url = ClassLoader.getSystemClassLoader().getResource("./words.txt");
            List<String> dictionary = WordsLoader.load(url.getPath());

            System.out.println("Dictionary Size: " + dictionary.size());

            startTime = new Date();

            String word = "stitter";

            if (args.length == 1) {
                word = args[0];
            }

            MatchData result;
            result = WordMatchingConcurrentCalculation.getBestMatchingWords(word, dictionary);
            List<String> results = result.getWords();
            endTime = new Date();
            System.out.println("Word: " + word);
            System.out.println("Minimun distance: " + result.getDistance());
            System.out.println("List of best matching words: " + results.size());
            for (String wordOut : results) {
                System.out.println(wordOut);
            }
            System.out.println("Execution Time: " + (endTime.getTime() - startTime.getTime()));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

}
