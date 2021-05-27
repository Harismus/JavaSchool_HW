import Exceptions.InvalidArgument;
import calculator.Calculator;

import java.util.concurrent.Callable;


class CallableClass implements Callable<Integer> {
    private Calculator calculator;
    private int arg;


    CallableClass(Calculator calculator, int arg) {
        this.calculator = calculator;
        this.arg = arg;
    }

    @Override
    public Integer call() throws InterruptedException {
        System.out.println( "Thread.currentThread().getName() begin= " + Thread.currentThread().getName() );
        int result = 0;
        synchronized(calculator) {

            if (arg == 0) {
                throw new InterruptedException("123");
            }

            System.out.println( "CallableClass.call" );
            Thread.sleep( 1000 );

            result = calculator.calcFactorial( arg );
        }
        System.out.println( "Thread.currentThread().getName() end = " + Thread.currentThread().getName() );
        return result;
    }
}