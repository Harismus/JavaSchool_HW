package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class Solution {
    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        solution.run();
    }

    private void run() throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] Array = new int[n];

        for (int i = 0; i < n; i++) {
            Array[i] = scan.nextInt();
        }

        ArrayList<Integer> ArrayMaxIndexes = new ArrayList<Integer>();

        for (int i = 0; i < 2; i++) {
            int max = Array[0];
            ArrayMaxIndexes.add(0);
            for (int j = 1; j < n; j++) {
                if (max == Array[j])
                {
                    ArrayMaxIndexes.add(j);
                }
                else if (max < Array[j])
                {
                    max = Array[j];
                    ArrayMaxIndexes.clear();
                    ArrayMaxIndexes.add(j);
                }
            }

            for (int index:ArrayMaxIndexes) {
                Array[index] = Array[index] / 2;
            }

            ArrayMaxIndexes.clear();
        }

        for (int number : Array) {
            System.out.println(number);
        }
    }
}