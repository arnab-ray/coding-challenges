package org.example.head_command;

import java.util.Scanner;

public class ReadFromStandardInput implements Reader {

    @Override
    public void read() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 11; i++) {
            String input = in.nextLine();
            System.out.println(input);
        }

        in.close();
    }
}
