package calculator;

import enums.cacheType;
import myannotation.CacheMethod;

public class CalculatorImpl implements Calculator {

    @CacheMethod(savedPlace = cacheType.FILE)
    @Override
    public Integer calcFactorial(int number) {
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
    public Double circleArea(String tag, final double M_PI, double Radius) {
        return M_PI * Radius * Radius;
    }
}