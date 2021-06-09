import calculator.CacheProxy;
import calculator.Calculator;
import calculator.CalculatorImpl;


import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args) {
        CacheProxy cacheProxy = new CacheProxy( Paths.get(  ".\\" ).toAbsolutePath());
        Calculator calculator = cacheProxy.cache(new CalculatorImpl());

        Runnable task1 = () -> {
            List<Integer> res =  calculator.calcRangeFactorial(1, 6 );
            System.out.println( "calcFactorial result = " + res);
        };

        Executor executor = (runnable) -> {
            new Thread(runnable).start();
        };
        executor.execute(task1);

        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
