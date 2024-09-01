package org.example.cut_command;

import java.util.Scanner;

public class StandardInputReader extends AbstractReader {
    @Override
    public void read(Position position, String delimiter) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();
            parseLine(input, position, delimiter);
        }
    }
}
