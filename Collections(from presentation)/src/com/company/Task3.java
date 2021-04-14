package com.company;

import java.util.Map;

/**
 *  Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
 *  */

public class Task3 extends AbstractTask {
    public static void Do(String buffer) {
        Map<String, Integer> wordsInfo = textParser.countWords(buffer);

        System.out.println("================Task3==================");
        System.out.println("Частота слов в файле: ");
        for (Map.Entry<String, Integer> wordInfo: wordsInfo.entrySet()) {
            System.out.println("word = " + wordInfo.getKey() + " count = " + wordInfo.getValue());
        }
    }
}
