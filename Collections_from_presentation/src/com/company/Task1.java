package com.company;

import javafx.util.Pair;

import java.util.Map;

/**
 * @brief Подсчитайте количество различных слов в файле.
 */
public class Task1 extends AbstractTask {
    public static void Do(String buffer) {
        Map<String, Integer> wordsInfo = textParser.countWords(buffer);

        System.out.println("================Task1==================");
        System.out.println("Количество различных слов в файле равно: " +  wordsInfo.size());
    }
}
