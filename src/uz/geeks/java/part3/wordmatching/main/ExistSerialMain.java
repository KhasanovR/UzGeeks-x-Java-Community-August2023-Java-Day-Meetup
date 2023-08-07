package uz.geeks.java.part3.wordmatching.main;

import uz.geeks.java.part3.wordmatching.data.WordsLoader;
import uz.geeks.java.part3.wordmatching.serial.ExistSerialCalculation;

import java.util.Date;
import java.util.List;

public class ExistSerialMain {
    //
    public static void main(String[] args) {
        //
        Date startTime;
        Date endTime;

        var url = ClassLoader.getSystemClassLoader().getResource("data/words.txt");
        List<String> dictionary = WordsLoader.load(url.getPath());

        System.out.println("Dictionary Size: " + dictionary.size());

        startTime = new Date();

        String word = "good";

        boolean result = ExistSerialCalculation.existWord(word, dictionary);
        endTime = new Date();

        System.out.println("Word: " + word);
        System.out.println("Exists: " + result);
        System.out.println("Execution Time: " + (endTime.getTime() - startTime.getTime()));
    }

}
