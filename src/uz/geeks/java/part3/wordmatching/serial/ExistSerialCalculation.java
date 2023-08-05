package uz.geeks.java.part3.wordmatching.serial;

import uz.geeks.java.part3.wordmatching.distance.LevenshteinDistance;

import java.util.List;

public class ExistSerialCalculation {

	public static boolean existWord(String word, List<String> dictionary) {
		for (String str: dictionary) {
			if (LevenshteinDistance.calculate(word, str)==0) {
				return true;
			}
		}
		return false;
	}
}
