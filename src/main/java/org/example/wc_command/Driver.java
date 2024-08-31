package org.example.wc_command;

public class Driver {

    public static void main(String[] args) {
        if (args.length < 1 || args.length > 3) {
            System.out.println("Usage: <flag> <file_name>");
            System.out.println("-c  -- print byte counts");
            System.out.println("-l  -- print line counts");
            System.out.println("-w  -- print word counts");
            System.out.println("-m  -- print character counts");
            return;
        }

        if (args.length == 2) {
            System.out.println("command: " + args[0] + ", fileName: " + args[1]);
            Counter reader = CounterFactory.create(args[0], args[1]);
            long count = reader.count();
            System.out.println(count + " " +  args[1]);
        } else {
            long byteCount = CounterFactory.create("-c", args[0]).count();
            long lineCount = CounterFactory.create("-l", args[0]).count();
            long wordCount = CounterFactory.create("-w", args[0]).count();
            System.out.println(lineCount + " " +  wordCount + " " + byteCount + " " + args[0]);
        }
    }
}
