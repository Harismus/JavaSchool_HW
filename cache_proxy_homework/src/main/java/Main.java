import cache.CacheProxy;
import calculator.Calculator;
import calculator.CalculatorImpl;

public class Main {
    public static void main(String[] args) {
        CacheProxy cacheProxy = new CacheProxy();

        Calculator calculator = cacheProxy.cache(new CalculatorImpl());

        Integer res =  calculator.calcFactorial(3 );
        System.out.println( "calcFactorial result = " + res);
    }
}
