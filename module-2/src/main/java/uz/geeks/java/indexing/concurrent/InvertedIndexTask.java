package uz.geeks.java.indexing.concurrent;

import uz.geeks.java.indexing.common.Document;

import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


public class InvertedIndexTask implements Runnable {
    //
    private CompletionService<Document> completionService;
    private ConcurrentHashMap<String, StringBuffer> invertedIndex;

    public InvertedIndexTask(CompletionService<Document> completionService,
                             ConcurrentHashMap<String, StringBuffer> invertedIndex) {
        this.completionService = completionService;
        this.invertedIndex = invertedIndex;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                try {
                    Document document = completionService.take().get();
                    updateInvertedIndex(document.getVoc(), invertedIndex, document.getFileName());
                } catch (InterruptedException e) {
                    break;
                }
            }
            while (true) {
                Future<Document> future = completionService.poll();
                if (future == null)
                    break;
                Document document = future.get();
                updateInvertedIndex(document.getVoc(), invertedIndex, document.getFileName());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void updateInvertedIndex(Map<String, Integer> voc, ConcurrentHashMap<String, StringBuffer> invertedIndex, String fileName) {
        for (String word : voc.keySet()) {
            if (word.length() >= 3) {
                StringBuffer buffer = invertedIndex.computeIfAbsent(word, k -> new StringBuffer());
                buffer.append(fileName).append(";");
            }
        }
    }

}
