package uz.geeks.java.indexing.serial;

import uz.geeks.java.indexing.common.DocumentParser;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SerialIndexing {
	//
	public static void main(String[] args) {
		//
		Date start;
		Date end;

		File source = new File("data");
		File[] files = source.listFiles();
		Map<String, StringBuffer> invertedIndex = new HashMap<String, StringBuffer>();

		start = new Date();
		for (File file : files) {

			DocumentParser parser = new DocumentParser();

			if (file.getName().endsWith(".txt")) {
				Map<String, Integer> voc = parser.parse(file.getAbsolutePath());
				updateInvertedIndex(voc, invertedIndex, file.getName());
				//indexWriter.updateInvertedIndex(voc, file.getName());
			}
		}
		end = new Date();
		System.out.println("Execution Time: " + (end.getTime() - start.getTime()));
		System.out.println("invertedIndex: " + invertedIndex.size());
		//System.out.println(invertedIndex.get("book").size());
	}

	private static void updateInvertedIndex(Map<String, Integer> voc, Map<String, StringBuffer> invertedIndex,
			String fileName) {
		for (String word : voc.keySet()) {
			if (word.length() >= 3) {
				invertedIndex.computeIfAbsent(word, k -> new StringBuffer()).append(fileName).append(";");
			}
		}
	}
}
