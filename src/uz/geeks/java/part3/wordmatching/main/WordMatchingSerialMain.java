package uz.geeks.java.part3.wordmatching.main;

import uz.geeks.java.part3.wordmatching.common.MatchData;
import uz.geeks.java.part3.wordmatching.data.WordsLoader;
import uz.geeks.java.part3.wordmatching.serial.BestMatchingSerialCalculation;

import java.util.Date;
import java.util.List;


public class WordMatchingSerialMain {
    //

    public static void main(String[] args) {
        //
        Date startTime;
        Date endTime;
        var url = ClassLoader.getSystemClassLoader().getResource("data/words.txt");
        List<String> dictionary = WordsLoader.load(url.getPath());

        System.out.println("Dictionary Size: " + dictionary.size());

        startTime = new Date();
        String word = "zymosimeters";

        if (args.length == 1) {
            word = args[0];
        }

        MatchData result = BestMatchingSerialCalculation.getBestMatchingWords(word, dictionary);
        List<String> results = result.getWords();
        endTime = new Date();
        System.out.println("Word: " + word);
        System.out.println("Minimum distance: " + result.getDistance());
        System.out.println("List of best matching words: " + results.size());
        results.forEach(System.out::println);
        System.out.println("Execution Time: " + (endTime.getTime() - startTime.getTime()));
    }

}
