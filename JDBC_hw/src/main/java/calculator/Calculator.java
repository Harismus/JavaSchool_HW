package calculator;

import connection.H2DataBase;
import enums.cacheType;
import myannotation.CacheMethod;
import myannotation.Cacheable;
import myannotation.Metric;

import java.util.List;

public interface Calculator {
    /**
     * Расчет факториала числа.
     *
     * @param number индекс
     */
    @CacheMethod(savedPlace = cacheType.MEMORY)
    @Metric
    @Cacheable(H2DataBase.class)
    Integer calcFactorial(int number);


    /**
     * @param begin начальный число
     * @param end   конечный число
     * @return
     */
    @CacheMethod(savedPlace = cacheType.FILE, sizeReturn = 100)
    @Metric
    @Cacheable(H2DataBase.class)
    List<Integer> calcRangeFactorial(int begin, int end);

    /**
     * @param tag    пометка
     * @param M_PI   константа
     * @param Radius некий радиус
     * @return возвращает значение площади круга
     */
    @CacheMethod(savedPlace = cacheType.MEMORY, identityBy = String.class, isZip = true)
    Double circleArea(String tag, final double M_PI, double Radius);


}