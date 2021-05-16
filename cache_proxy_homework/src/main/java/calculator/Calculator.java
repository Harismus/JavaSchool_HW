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
    @CacheMethod(savedPlace = cacheType.FILE, identityBy = String.class, isZip = true)
    Double circleArea(String tag, final double M_PI, double Radius);


}