package com.company;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cmCount = scanner.nextInt();

        int inchCount = cmCount / 3;
        int inchRemainder = cmCount % 3;

        inchCount += inchRemainder > 1 ? 1 : 0;

        int foots = inchCount / 12;
        int inches = inchCount % 12;

        System.out.println(foots + " " + inches);
    }
}
