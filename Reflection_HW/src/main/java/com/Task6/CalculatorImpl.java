package com.Task6;



public class CalculatorImpl implements Calculator {

    @Override
    public int calc(int number) {
        System.out.println( "number = " + number );
        if (number <= 0) {
            return 0;
        }
        int res = 1;

        for (int i = 2; i <= number; i++) {
            res *= i;
        }
        return res;
    }
}