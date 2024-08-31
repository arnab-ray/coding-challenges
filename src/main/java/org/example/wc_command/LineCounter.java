package org.example.wc_command;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LineCounter implements Counter {
    private final String fileName;

    public LineCounter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public long count() {
        try {
            return countLine(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public long countLine(String fileName) throws IOException {
        String completeFilepath = "./src/main/java/org/example/wc_command/" + fileName;
        Path path = Paths.get(completeFilepath);
        return Files.readAllLines(path).size();
    }
}
