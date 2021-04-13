package com.company;

import java.util.Arrays;
import java.util.List;

public class ArrayCast {
    public static List<String> from(String buffer) {
        return Arrays.asList(buffer.split("\\s+"));
    }
}
