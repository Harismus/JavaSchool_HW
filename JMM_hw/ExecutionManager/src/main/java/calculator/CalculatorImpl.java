package calculator;


public class CalculatorImpl implements Calculator {

    @Override
    public Integer calcFactorial(int number) throws ArithmeticException  {
        if (number <= 0) {
            throw new ArithmeticException ( "InvalidArgument" );
        }
        int res = 1;

        for (int i = 2; i <= number; i++) {
            res *= i;
        }
        return res;
    }

}