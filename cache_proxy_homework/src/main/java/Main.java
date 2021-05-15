import cache.CacheProxy;
import calculator.Calculator;
import calculator.CalculatorImpl;

import java.io.File;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        CacheProxy cacheProxy = new CacheProxy( Paths.get(  "." + File.separatorChar ).toAbsolutePath());

        Calculator calculator = cacheProxy.cache(new CalculatorImpl());
//
////        Integer res =  calculator.calcFactorial(3 );
////        System.out.println( "calcFactorial result = " + res);

        Double square = calculator.circleArea("0", 3.14, 10);
        System.out.println( "square = " + square );
    }
}
