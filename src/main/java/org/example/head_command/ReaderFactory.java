package org.example.head_command;

import java.util.List;

public class ReaderFactory {

    public Reader getReader(List<String> fileNames) {
        if (fileNames == null || fileNames.isEmpty())
            return new ReadFromStandardInput();
        else
            return new ReadFromFile(fileNames);
    }

    public Reader getReader(TypeOfRead type, int count, List<String> fileNames) {
        if (fileNames == null || fileNames.isEmpty())
            return new ReadFromStandardInput();
        else
            return new ReadFromFile(fileNames, type, count);
    }
}
