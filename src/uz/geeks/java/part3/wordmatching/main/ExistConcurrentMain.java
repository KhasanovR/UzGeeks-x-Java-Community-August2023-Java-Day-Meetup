package uz.geeks.java.part3.wordmatching.main;

import uz.geeks.java.part3.wordmatching.concurrent.ExistsConcurrentCalculation;
import uz.geeks.java.part3.wordmatching.data.WordsLoader;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ExistConcurrentMain {
    //

    public static void main(String[] args) {
        //
        try {
            Date startTime;
            Date endTime;

            var url = ClassLoader.getSystemClassLoader().getResource("data/words.txt");
            List<String> dictionary = WordsLoader.load(url.getPath());

            System.out.println("Dictionary Size: " + dictionary.size());

            startTime = new Date();

            String word = "good";

            boolean result;
            result = ExistsConcurrentCalculation.existWord(word, dictionary);
            endTime = new Date();
            System.out.println("Word: " + word);
            System.out.println("Exist: " + result);
            System.out.println("Execution Time: " + (endTime.getTime() - startTime.getTime()));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

}
