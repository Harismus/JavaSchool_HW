package com.company;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int result = ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0))? 1 : 0;
        System.out.println(result);
    }
}