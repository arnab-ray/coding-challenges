package org.example.wc_command;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ByteCounter implements Counter {
    private final String fileName;

    public ByteCounter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public long count() {
        try {
            return byteCount(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long byteCount(String fileName) throws IOException {
        String completeFilepath = "./src/main/java/org/example/wc_command/" + fileName;
        Path path = Paths.get(completeFilepath);
        return Files.readAllBytes(path).length;
    }
}
