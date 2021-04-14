package com.company;


import java.io.IOException;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
        try {

//            String buffer = FileReader.read(Paths.get("src/com/company/SrcText.txt").toAbsolutePath());
//            FileWriter.write(Paths.get("src/com/company/ResultText.txt").toAbsolutePath(), buffer, 10);


            String bufferResult = FileReader.read(Paths.get("src/com/company/ResultText.txt").toAbsolutePath());
            Task1.Do(bufferResult);
            Task2.Do(bufferResult);
            Task3.Do(bufferResult);
            Task4.Do(bufferResult);
            Task5.Do(bufferResult);
            Task6.Do(bufferResult);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


