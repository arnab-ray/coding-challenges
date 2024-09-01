package org.example.cut_command;

public class ReaderFactory {
    public static Reader create(String fileName) {
        if (fileName.isEmpty() || fileName.equals("-"))
            return new StandardInputReader();
        else
            return new FileReader(fileName);
    }
}
