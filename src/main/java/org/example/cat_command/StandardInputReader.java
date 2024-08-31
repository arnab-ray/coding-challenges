package org.example.cat_command;

import java.util.Scanner;

public class StandardInputReader implements Reader {

    @Override
    public void read() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();
            System.out.println(input);
        }

        in.close();
    }
}
