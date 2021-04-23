package com.company.readcontent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = new String();
        CommandLine commandLine = new CommandLine( args );
        if (commandLine.hasUrl()) {
            url = commandLine.getUrl();
        } else {
            Scanner scanner = new Scanner( System.in );
            url = scanner.nextLine();
        }

        Reader.readContent( url );
    }
}



