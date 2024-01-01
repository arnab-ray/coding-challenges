package org.example.head_command;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    private static void checkFileNameValidity(String fileName) {
        if (fileName.startsWith("-n") || fileName.startsWith("-c")) {
            System.out.println("Invalid input fileName");
            System.exit(1);
        }
    }

    private static void checkCommandValidity(String command) {
        if (!(command.startsWith("-n") || command.startsWith("-c"))) {
            System.out.println("Invalid input command");
            System.exit(2);
        }
    }

    public static void main(String[] args) {
        List<String> fileNames = new ArrayList<>();

        if (args.length <= 2) {
            String fileName = args.length > 1 ? args[1] : "";
            checkFileNameValidity(fileName);
            fileNames.add(fileName);
            Reader reader = new ReaderFactory().getReader(fileNames);
            reader.read();
        } else if (args.length == 3) {
            String command = args[1];
            checkCommandValidity(command);
            String fileName = args[2];
            checkFileNameValidity(fileName);
            fileNames.add(fileName);
            TypeOfRead type = command.startsWith("-n") ? TypeOfRead.LINE : TypeOfRead.BYTE;
            int count = Integer.parseInt(command.substring(2));
            Reader reader = new ReaderFactory().getReader(type, count, fileNames);
            reader.read();
        } else {
            String command = args[1];
            checkCommandValidity(command);
            int count = Integer.parseInt(args[2]);

            for (int i = 3; i < args.length; i++) {
                String fileName = args[i];
                checkFileNameValidity(fileName);
                fileNames.add(fileName);
            }
            TypeOfRead type = command.startsWith("-n") ? TypeOfRead.LINE : TypeOfRead.BYTE;
            Reader reader = new ReaderFactory().getReader(type, count, fileNames);
            reader.read();
        }
    }
}
