package org.example.head_command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ReadFromFile implements Reader {

    private final List<String> fileNames;
    private final TypeOfRead type;
    private final int number;

    public ReadFromFile(List<String> fileNames) {
        this.fileNames = fileNames;
        this.type = TypeOfRead.LINE;
        this.number = 10;
    }

    public ReadFromFile(List<String> fileNames, TypeOfRead type, int number) {
        this.fileNames = fileNames;
        this.type = type;
        this.number = number;
    }

    @Override
    public void read() {
        try {
            for (String fileName : fileNames) {
                System.out.println("==> " + fileName + " <==");
                if (type == TypeOfRead.LINE) {
                    readLine(number, fileName);
                } else {
                    readBytes(number, fileName);
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void readLine(int number, String fileName) throws IOException {
        String completeFilepath = "./src/main/java/org/example/head_command/" + fileName;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(completeFilepath));
        String line;
        int count = 0;
        while (count < number && (line = bufferedReader.readLine()) != null) {
            System.out.println(line);
            count++;
        }
    }

    private void readBytes(int number, String fileName) throws IOException {
        System.out.println("Reading file with bytes");
        String completeFilepath = "./src/main/java/org/example/head_command/" + fileName;
        File myFile = new File(completeFilepath);
        int minNumber = (int) Math.min(number, myFile.length());
        byte[] bytes = new byte[minNumber];
        InputStream inputStream = new FileInputStream(myFile);
        inputStream.read(bytes);
        inputStream.close();
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }
}
