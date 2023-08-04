package uz.geeks.java.indexing.concurrent;

import uz.geeks.java.indexing.common.Document;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MultipleInvertedIndexTask implements Runnable {
    //
    private CompletionService<List<Document>> completionService;
    private ConcurrentHashMap<String, StringBuffer> invertedIndex;

    public MultipleInvertedIndexTask(CompletionService<List<Document>> completionService, ConcurrentHashMap<String, StringBuffer> invertedIndex) {
        //
        this.completionService = completionService;
        this.invertedIndex = invertedIndex;
    }

    @Override
    public void run() {
        //
        try {
            while (!Thread.interrupted()) {
                try {
                    List<Document> documents = completionService.take().get();
                    for (Document document : documents) {
                        updateInvertedIndex(document.getVoc(), invertedIndex, document.getFileName());
                        //indexWriter.updateInvertedIndex(document.getVoc(), document.getFileName());
                    }
                } catch (InterruptedException e) {
                    break;
                }
            }
            while (true) {
                Future<List<Document>> future = completionService.poll();
                if (future == null)
                    break;
                List<Document> documents = future.get();
                for (Document document : documents) {
                    updateInvertedIndex(document.getVoc(), invertedIndex, document.getFileName());
                    //indexWriter.updateInvertedIndex(document.getVoc(), document.getFileName());
                }
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private void updateInvertedIndex(
            Map<String, Integer> voc,
            ConcurrentHashMap<String, StringBuffer> invertedIndex,
            String fileName) {

        for (String word : voc.keySet()) {
            if (word.length() >= 3) {
                StringBuffer buffer = invertedIndex.computeIfAbsent(word, k -> new StringBuffer());
                synchronized (buffer) {
                    buffer.append(fileName).append(";");
                }
            }
        }
    }


}
