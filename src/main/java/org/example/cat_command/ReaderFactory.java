package org.example.cat_command;

import java.util.List;

public class ReaderFactory {

    public Reader getReader(List<String> fileNames) {
        if (fileNames.size() == 1 && isFlagParam(fileNames.get(0))) {
            if (isNumericFlagParam(fileNames.get(0))) {
                return new NumericStandardInputReader();
            } else {
                return new StandardInputReader();
            }
        } else {
            return new FileReader(fileNames);
        }
    }

    private boolean isFlagParam(String fileName) {
        return fileName.equals("-") || isNumericFlagParam(fileName);
    }

    private boolean isNumericFlagParam(String fileName) {
        return fileName.equals("-n") || fileName.equals("-b");
    }
}
