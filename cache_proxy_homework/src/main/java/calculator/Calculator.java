package calculator;

import enums.cacheType;
import myannotation.CacheMethod;
import myannotation.Metric;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number
     */
    @CacheMethod(savedPlace = cacheType.MEMORY)
    @Metric
    Integer calcFactorial (int number);

    Double circleArea(double M_PI, double Radius);
}