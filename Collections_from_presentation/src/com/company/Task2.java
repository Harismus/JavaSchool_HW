package com.company;

import java.util.*;
import java.util.function.Consumer;

/**
 * @brief Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
 */
public class Task2 extends AbstractTask {

    static Comparator<String> lengthComparator = new Comparator<String>() {
        @Override
        public int compare(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return 1;
            } else if (s1.length() < s2.length()) {
                return -1;
            } else {
                return 0;
            }
        }
    };

    static Comparator<String> alphaComparator = new Comparator<String>() {
        private String letters = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";

        @Override
        public int compare(String lhs, String rhs) {
            int lp = letters.indexOf(lhs);
            int rp = letters.indexOf(rhs);
            if (lp != -1 && rp != -1) {
                return new Integer(lp).compareTo(rp);
            }
            return lhs.compareTo(rhs);
        }
    };


    public static void Do(String buffer) {
        Map<String, Integer> wordsInfo = textParser.countWords(buffer);

        System.out.println("================Task2==================");

        Consumer<Comparator<String>> printSortUniqueWords = (comparator) -> {
            Set<String> words = new TreeSet<>(comparator);
            words.addAll(wordsInfo.keySet());

            for (String word : words) {
                System.out.println("word = " + word);
            }

            System.out.println("\n");
        };

        System.out.println("Сортировка по длинне слов:");
        printSortUniqueWords.accept(lengthComparator);
        System.out.println("Сортировка по алфавиту:");
        printSortUniqueWords.accept(alphaComparator);
    }
}
