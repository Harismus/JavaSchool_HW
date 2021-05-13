import enums.SAVED_PLACE;
import myannotation.CacheMethod;
import myannotation.Metric;

public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number
     */
    @CacheMethod(savedPlace = SAVED_PLACE.FILE)
    @Metric
    Integer calcFactorial (int number);

    Double circleArea(double M_PI, double Radius);
}