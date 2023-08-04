package uz.geeks.java.wordmatching.common;

import java.util.List;

public class MatchData {
    //
    private int distance;

    private List<String> words;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }
}
