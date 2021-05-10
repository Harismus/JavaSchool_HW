package com.Task1;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Calculator calculator = new CalculatorImpl();

        for (int i = 0; i < 6; i++) {
            System.out.println( "calculator.calc(" + i + ") = " + calculator.calc( i ) );
        }
    }
}
