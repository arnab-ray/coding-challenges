package org.example.cat_command;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

public class FileReader implements Reader {

    private final List<String> fileNames;

    public FileReader(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    @Override
    public void read() {
        fileNames.forEach(fileName -> {
            try {
                readLine(fileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void readLine(String fileName) throws IOException {
        String completeFilepath = "./src/main/java/org/example/cat_command/" + fileName;
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(completeFilepath));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
