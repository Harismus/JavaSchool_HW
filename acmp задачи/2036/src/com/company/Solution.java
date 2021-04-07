package com.company;

import java.nio.file.DirectoryStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.util.function.Predicate;

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.run();
    }

    private void run() throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();

        ArrayList<String> ArrayMaxIndexes = new ArrayList<String>();

        ArrayList<Character> ArrayStrangeWords = new ArrayList<Character>();
        ArrayStrangeWords.add('e');
        ArrayStrangeWords.add('y');
        ArrayStrangeWords.add('u');
        ArrayStrangeWords.add('i');
        ArrayStrangeWords.add('o');
        ArrayStrangeWords.add('a');

        Operationable operation = (String string) ->
        {
            boolean b = false;
            int countVowel = 0;
            boolean isStrangeSymbol = false;
            for (int i = 0; i < string.length(); ++i) {

                for (char c : ArrayStrangeWords) {
                    if (string.charAt(i) == c) {
                        countVowel++;
                        isStrangeSymbol = true;
                        break;
                    }
                }

                if (!isStrangeSymbol && countVowel >= 3) {
                    break;
                }

                if (!isStrangeSymbol) {
                    countVowel = 0;
                }

                isStrangeSymbol = false;
            }
            b = countVowel < 3;
            return b;
        };

        for (int i = 0; i < n; i++) {
            String string = scan.nextLine();
            if (operation.isNotStrange(string))
                ArrayMaxIndexes.add(string);
        }

        for (String string : ArrayMaxIndexes) {
            System.out.println(string);
        }
    }

    interface Operationable {
        boolean isNotStrange(String string);
    }


}
