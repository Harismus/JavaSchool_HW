import java.io.Serializable;

public class CalculatorImpl implements Calculator, Serializable {

    @Override
    public int calcFactorial(int number) {
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