import calculator.CalculatorImpl;
import thread.ThreadPool;
import thread.ThreadPoolImpl;

public class Main {
    public static void main(String[] args) {

        ThreadPool threadPool = new ThreadPoolImpl(2);

        for (int i = 1; i < 5; i++) {
            threadPool.execute( new TestTask(new CalculatorImpl(), i) );
        }


        threadPool.start();

        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        for (int i = 5; i < 10; i++) {
            threadPool.execute( new TestTask(new CalculatorImpl(), i) );
        }


    }
}
