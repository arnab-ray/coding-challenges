package org.example.cat_command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver {
    private static void checkFileNameValidity(String fileName) {
        if (fileName.startsWith("-n") || fileName.startsWith("-b")) {
            System.out.println("Invalid input fileName " + fileName);
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        if (args.length <= 2) {
            String fileName = (args.length > 1) ? args[1] : "";
            Reader reader = new ReaderFactory().getReader(List.of(fileName));
            reader.read();
        } else {
            List<String> fileNames = new ArrayList<>(Arrays.asList(args).subList(1, args.length));

            fileNames.forEach(Driver::checkFileNameValidity);
            Reader reader = new ReaderFactory().getReader(fileNames);
            reader.read();
        }
    }
}
