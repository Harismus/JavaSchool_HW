package com.company;

import java.util.List;

/**
 * : Выведите на экран все строки файла в обратном порядке.
 */

public class Task4 extends AbstractTask {
    public static void Do(String buffer) {
        System.out.println("================Task4==================");

        List<String> lines = ArrayCast.from(buffer, "\\n");

        for (int i = lines.size() - 1; i >= 0 ; --i) {
            System.out.println("str = " + lines.get(i));
        }
    }
}
