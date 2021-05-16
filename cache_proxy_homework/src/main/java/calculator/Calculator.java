package calculator;

import enums.cacheType;
import myannotation.CacheMethod;
import myannotation.Metric;

import java.util.List;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number индекс
     */
    @CacheMethod(savedPlace = cacheType.MEMORY)
    @Metric
    Integer calcFactorial (int number);


    /**
     *
     * @param begin начальный число
     * @param end конечный число
     * @return
     */
    @CacheMethod(savedPlace = cacheType.MEMORY)
    @Metric
    List<Integer> calcRangeFactorial (int begin, int end);

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