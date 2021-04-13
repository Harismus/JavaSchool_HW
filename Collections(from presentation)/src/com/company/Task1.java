package com.company;

import javafx.util.Pair;

import java.util.Map;

/**
 * @brief Подсчитайте количество различных слов в файле.
 */
public class Task1 extends AbstractTask {
    public static void Do(String buffer) {
        Map<String, Integer> wordsInfo = textParser.countWords(buffer);

        for (Map.Entry<String, Integer> wordInfo: wordsInfo.entrySet()) {
            System.out.println("word = " + wordInfo.getKey() + " count = " + wordInfo.getValue());
        }
    }
}
