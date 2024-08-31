package org.example.wc_command;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CharacterCounter implements Counter {
    private final String fileName;

    public CharacterCounter(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public long count() {
        try {
            return countChars(fileName);
        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private long countChars(String fileName) throws IOException, URISyntaxException {
        String completeFilepath = "./src/main/java/org/example/wc_command/" + fileName;
        Path path = Paths.get(completeFilepath);
        return Files.readString(path).length();
    }
}
