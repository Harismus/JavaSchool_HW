package calculator;

import enums.cacheType;
import myannotation.CacheMethod;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImpl implements Calculator {

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
    public List<Integer> calcRangeFactorial(int begin, int end) {

        List<Integer> list = new ArrayList<>();
        for (int i = begin; i < end; i++) {
            Integer res = calcFactorial( i );
            list.add( res );
        }
        return list;
    }

    @Override
    public Double circleArea(String tag, final double M_PI, double Radius) {
        return M_PI * Radius * Radius;
    }
}