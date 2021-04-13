package com.company;


import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;


public class FileWriter {
    static void write(Path pathToFile, String buffer, int stringLength) throws IOException {

        OutputStream output = Files.newOutputStream(pathToFile);

        List<String> stringList = Arrays.asList(buffer.split(" "));

        String line = new String();
        for (int i = 0; i < stringList.size(); i++) {
            line += stringList.get(i);
            line += " ";

            if (line.length() > stringLength) {
                output.write(line.getBytes(StandardCharsets.UTF_8));
                output.write('\n');

                line = "";
            }

        }

        output.close();
    }
}
