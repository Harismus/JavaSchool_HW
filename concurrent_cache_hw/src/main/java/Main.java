import calculator.CacheProxy;
import calculator.Calculator;
import calculator.CalculatorImpl;


import java.nio.file.Paths;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) {

        CacheProxy cacheProxy = new CacheProxy( Paths.get(  ".\\" ).toAbsolutePath());

        Calculator calculator = cacheProxy.cache(new CalculatorImpl());

//        Runnable task1 = () -> {
//            Double  square = calculator.circleArea("2", 3.14, 10);
//            System.out.println( "square = " + square );
//        };
//
//        Runnable task2 = () -> {
//            Double  square = calculator.circleArea("2", 3.14, 10);
//            System.out.println( "square = " + square );
//        };

        Runnable task2 = () -> {
            Integer res =  calculator.calcFactorial(3 );
            System.out.println( "calcFactorial result = " + res);


        };

        Runnable task1 = () -> {
            Integer res =  calculator.calcFactorial(3 );
            System.out.println( "calcFactorial result = " + res);
        };


        Runnable task3 = () -> {
            Integer res =  calculator.calcFactorial(3 );
            System.out.println( "calcFactorial result = " + res);
        };

        Executor executor = (runnable) -> {
            new Thread(runnable).start();
        };
        executor.execute(task1);
        executor.execute(task2);

        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.execute(task3);
        executor.execute(task2);

        
    }
}
