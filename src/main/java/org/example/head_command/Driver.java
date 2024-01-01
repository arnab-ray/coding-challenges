package org.example.head_command;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        String fileName = args.length > 1 ? args[1] : "";
        if (fileName.isEmpty()) {
            Scanner in = new Scanner(System.in);
            for (int i = 0; i < 11; i++) {
                String input = in.nextLine();
                System.out.println(input);
            }

            in.close();
        } else {
            try {
                String completeFilepath = "./src/main/java/org/example/head_command/" + fileName;
                BufferedReader bufferedReader = new BufferedReader(new FileReader(completeFilepath));
                String line;
                int count = 0;
                while (count < 10 && (line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                    count++;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
