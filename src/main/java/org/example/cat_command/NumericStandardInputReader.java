package org.example.cat_command;

import java.util.Scanner;

public class NumericStandardInputReader implements Reader {
    @Override
    public void read() {
        int counter = 1;
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();
            System.out.println(counter + " " + input);
            counter++;
        }

        in.close();
    }
}
