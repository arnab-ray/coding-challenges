package org.example.wc_command;

public class CounterFactory {

    public static Counter create(String command, String fileName) {
        switch (command) {
            case "-c":
                return new ByteCounter(fileName);
            case "-l":
                return new LineCounter(fileName);
            case "-w":
                return new WordCounter(fileName);
            case "-m":
                return new CharacterCounter(fileName);
            default:
                throw new UnsupportedOperationException("Operation not supported");
        }
    }
}
