package org.example.cut_command;

public abstract class AbstractReader implements Reader {

    void parseLine(String line, Position position, String delimiter) {
        if (position.getEnd() == null) {
            System.out.println(line.split(delimiter)[position.getStart() - 1]);
        } else {
            for (int i = position.getStart() - 1; i < position.getEnd(); i++) {
                if (i < position.getEnd() - 1) {
                    System.out.print(line.split(delimiter)[i] + delimiter);
                } else {
                    System.out.print(line.split(delimiter)[i]);
                }
            }
            System.out.println();
        }
    }
}
