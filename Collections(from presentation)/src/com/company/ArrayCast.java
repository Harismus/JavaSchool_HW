package com.company;

import java.util.Arrays;
import java.util.List;

public class ArrayCast {
    public static List<String> from(String buffer) {
        return Arrays.asList(buffer.split("\\s+"));
    }

    public static List<String> from(String buffer, String regex) {
        return Arrays.asList(buffer.split(regex));
    }
}
