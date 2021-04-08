package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        ArrayList<Integer> minNumbers = new ArrayList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int current = scanner.nextInt();

            if (min > current)
            {
                min = current;
                minNumbers.clear();
                minNumbers.add(i + 1);
            }
            else if (min == current)
            {
                minNumbers.add(i + 1);
            }
        }

        System.out.println(minNumbers.get(0));
    }
}
