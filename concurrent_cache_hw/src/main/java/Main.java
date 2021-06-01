import calculator.CacheProxy;
import calculator.Calculator;
import calculator.CalculatorImpl;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) {
        CacheProxy cacheProxy = new CacheProxy( Paths.get(  "." + File.separatorChar ).toAbsolutePath());

        Calculator calculator = cacheProxy.cache(new CalculatorImpl());

        Runnable task1 = () -> {
            Double  square = calculator.circleArea("2", 3.14, 10);
            System.out.println( "square = " + square );
        };

        Runnable task2 = () -> {
            Integer res =  calculator.calcFactorial(3 );
            System.out.println( "calcFactorial result = " + res);
        };

        Runnable task3 = () -> {
            Double  square = calculator.circleArea("3", 3.14, 10);
            System.out.println( "square = " + square );
        };

        Executor executor = (runnable) -> {
            new Thread(runnable).start();
        };
        executor.execute(task1);
        executor.execute(task2);
        executor.execute(task3); //!< изменился параметр по котору кешируется метод, чтобы не читался из кеша



        
        
    }
}
