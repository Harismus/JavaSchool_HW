package com.Task1;

public class CalculatorImpl implements Calculator {
    public void test() {
        System.out.println( "void test" );
    }

    @Override
    public int calc(int number) {
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
