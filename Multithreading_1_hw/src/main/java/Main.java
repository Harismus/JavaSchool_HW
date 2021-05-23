import calculator.Calculator;
import calculator.CalculatorImpl;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
class test {
    final String name;
    test(String name) {
        this.name = name;
    }
}


public class Main {
    public static void main(String[] args) {

        Calculator calc = new CalculatorImpl();


        Scanner in = new Scanner(System.in);
        System.out.print("Input count number: ");
        int n = in.nextInt();


        List<Thread> listThread = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            int number = in.nextInt();
            FactorialTask factorialTask = new FactorialTask( calc, number );
            listThread.add(new Thread(factorialTask,"MyThread") );
        }


        for (Thread thread:listThread) {
            thread.start();
        }
    }
}
