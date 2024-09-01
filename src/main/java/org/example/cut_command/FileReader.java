package org.example.cut_command;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader extends AbstractReader {
    private final String fileName;
    private final String defaultDelimiter;

    public FileReader(String fileName) {
        this.fileName = fileName;
        this.defaultDelimiter = "\\t+";
    }

    @Override
    public void read(Position position, String delimiter) {
        String completeFilepath = "./src/main/java/org/example/cut_command/" + fileName;
        try (var bufferedReader = new BufferedReader(new java.io.FileReader(completeFilepath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                parseLine(line, position, delimiter == null ? defaultDelimiter : delimiter);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
