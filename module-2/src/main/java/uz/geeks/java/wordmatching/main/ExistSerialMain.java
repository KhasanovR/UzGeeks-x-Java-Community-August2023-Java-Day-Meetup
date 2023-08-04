package uz.geeks.java.wordmatching.main;

import uz.geeks.java.wordmatching.data.WordsLoader;
import uz.geeks.java.wordmatching.serial.ExistSerialCalculation;

import java.util.Date;
import java.util.List;

public class ExistSerialMain {
    //
    public static void main(String[] args) {
        //
        Date startTime;
        Date endTime;

        var url = ClassLoader.getSystemClassLoader().getResource("./words.txt");
        List<String> dictionary = WordsLoader.load(url.getPath());

        System.out.println("Dictionary Size: " + dictionary.size());

        startTime = new Date();

        String word = "zymosimeters";

        if (args.length == 1) {
            word = args[0];
        }

        boolean result = ExistSerialCalculation.existWord(word, dictionary);
        endTime = new Date();

        System.out.println("Word: " + word);
        System.out.println("Exists: " + result);
        System.out.println("Execution Time: " + (endTime.getTime() - startTime.getTime()));
    }

}
