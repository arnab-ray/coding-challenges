package org.example.cut_command;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String[] args) {
        assert args.length > 1 : "Usage <position> (optional)<delimiter> <fileName>";

        String positionParams = null, delimiter = null;

        for (String arg : args) {
            if (arg.startsWith("-f")) positionParams = arg.substring(2);
            if (arg.startsWith("-d")) delimiter = arg.substring(2);
        }

        assert positionParams != null : "Please pass position";

        String lastArg = args[args.length - 1];
        String fileName = isNotFileName(lastArg) ? "" : lastArg;

        Reader reader = ReaderFactory.create(fileName);

        List<Integer> pos = Arrays.stream(positionParams.split(",|\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        Position position = Position.create(pos);

        System.out.println("delimiter: " + delimiter + "; position: " + position);
        reader.read(position, delimiter);
    }

    private static boolean isNotFileName(String name) {
        return name.startsWith("-f") || name.startsWith("-d");
    }
}
