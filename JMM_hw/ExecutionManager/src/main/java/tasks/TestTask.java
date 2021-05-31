package tasks;

import calculator.CalculatorImpl;

public class TestTask implements Runnable {
    private CalculatorImpl calculator;
    private int arg;


    public TestTask(CalculatorImpl calculator, int arg) {
        this.calculator = calculator;
        this.arg = arg;
    }

    @Override
    public void run() {
            int res  = calculator.calcFactorial( arg );
            System.out.println( "arg = " + arg + " res = " + res);
    }
}
