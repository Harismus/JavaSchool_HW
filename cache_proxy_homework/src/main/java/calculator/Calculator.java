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

    /**
     *
     * @param tag пометка
     * @param M_PI константа
     * @param Radius некий радиус
     * @return возвращает значение площади круга
     */
    @CacheMethod(savedPlace = cacheType.MEMORY, identityBy = String.class)
    Double circleArea(String tag, final double M_PI, double Radius);


}