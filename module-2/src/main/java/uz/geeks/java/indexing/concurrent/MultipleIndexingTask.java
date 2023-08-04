package uz.geeks.java.indexing.concurrent;

import uz.geeks.java.indexing.common.Document;
import uz.geeks.java.indexing.common.DocumentParser;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class MultipleIndexingTask implements Callable<List<Document>> {
    //
    private List<File> files;

    public MultipleIndexingTask(List<File> files) {
        //
        this.files = files;
    }

    @Override
    public List<Document> call() {
        List<Document> documents = new ArrayList<Document>();
        DocumentParser parser = new DocumentParser();
        for (File file : files) {
            Map<String, Integer> voc = parser.parse(file.getAbsolutePath());

            Document document = new Document();
            document.setFileName(file.getName());
            document.setVoc(voc);

            documents.add(document);
        }
        return documents;
    }
}
