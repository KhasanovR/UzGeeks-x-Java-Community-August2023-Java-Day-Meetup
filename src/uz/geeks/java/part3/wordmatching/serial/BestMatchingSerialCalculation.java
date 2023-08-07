package uz.geeks.java.part3.wordmatching.serial;

import uz.geeks.java.part3.wordmatching.common.MatchData;
import uz.geeks.java.part3.wordmatching.distance.LevenshteinDistance;

import java.util.ArrayList;
import java.util.List;

public class BestMatchingSerialCalculation {
    //
    public static MatchData getBestMatchingWords(String word, List<String> dictionary) {
        //
        List<String> results = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        int distance;
        for (String str : dictionary) {
            distance = LevenshteinDistance.calculate(word, str);
            if (distance < minDistance) {
                results.clear();
                minDistance = distance;
                results.add(str);
            } else if (distance == minDistance) {
                results.add(str);
            }
        }

        MatchData result = new MatchData();
        result.setWords(results);
        result.setDistance(minDistance);
        return result;
    }

}
