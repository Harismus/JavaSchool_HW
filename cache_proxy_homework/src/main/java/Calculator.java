public interface Calculator {
    /**
     * Расчет факториала числа.
     * @param number
     */
    @CacheMethod(savedPlace = SAVED_PLACE.MEMORY)
    @Metric
    int calcFactorial (int number);
}