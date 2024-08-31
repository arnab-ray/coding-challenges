package org.example.wc_command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class WordCounter implements Counter {
    private final String fileName;

    public WordCounter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public long count() {
        try {
            return readWordCount(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long readWordCount(String fileName) throws IOException {
        String completeFilepath = "./src/main/java/org/example/wc_command/" + fileName;
        Path path = Paths.get(completeFilepath);
        return Arrays.stream(Files.readString(path).split("\\s+")).filter(it -> !it.isEmpty()).count();
    }
}
