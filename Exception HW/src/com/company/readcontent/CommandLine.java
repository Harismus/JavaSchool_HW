package com.company.readcontent;

public class CommandLine {
    private String[] args;

    CommandLine(String[] args) {
        this.args = args;
    }

    boolean hasUrl() {
        return args.length > 0 && !args[0].isEmpty();
    }

    public String getUrl() {
        return args[0];
    }
}
