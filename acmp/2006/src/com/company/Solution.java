package com.company;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cmCount = scanner.nextInt();

        int inches = cmCount % 3 > 1 ? cmCount / 3 + 1 : cmCount / 3;

        System.out.println(inches / 12 + " " + inches % 12);
    }
}
