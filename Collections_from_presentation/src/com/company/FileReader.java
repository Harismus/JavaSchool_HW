package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class FileReader {

    static String read(Path pathToFile) throws IOException {

        InputStream input = Files.newInputStream(pathToFile);

        String buffer = new BufferedReader(new InputStreamReader(input))
                .lines().collect(Collectors.joining("\n"));

        return buffer;
    }
}
