import enums.SAVED_PLACE;
import myannotation.CacheMethod;

import java.io.Serializable;

public class CalculatorImpl implements Calculator, Serializable {

    @CacheMethod(savedPlace = SAVED_PLACE.FILE)
    @Override
    public Integer calcFactorial(int number) {
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

    @Override
    public Double circleArea(final double M_PI, double Radius) {
        return M_PI * Radius * Radius;
    }
}