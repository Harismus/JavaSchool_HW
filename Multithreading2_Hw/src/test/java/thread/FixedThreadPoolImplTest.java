package thread;

import calculator.CalculatorImpl;
import org.junit.Before;
import org.junit.Test;
import tasks.TestTask;


public class FixedThreadPoolImplTest {

    ThreadPool threadPool = new FixedThreadPoolImpl(2);

    @Before
    public void init() {
        for (int i = 1; i < 5; i++) {
            threadPool.execute( new TestTask(new CalculatorImpl(), i) );
        }
    }



    @Test
    public void start() {
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