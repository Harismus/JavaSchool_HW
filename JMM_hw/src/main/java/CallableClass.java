import calculator.Calculator;

import java.util.concurrent.Callable;

//-----------------------------------------------------
// Класс, реализующий интерфейс Callable
class CallableClass implements Callable<Integer> {

    Calculator calculator;
    int arg;


    CallableClass(Calculator calculator, int arg) {
        this.calculator = calculator;
        this.arg = arg;
    }

    @Override
    public Integer call() throws Exception {
        System.out.println( "Thread.currentThread().getName()111 = " + Thread.currentThread().getName() );
        int result = 0;
        synchronized(calculator) {
            System.out.println( "CallableClass.call" );
            Thread.sleep( 1000 );
            // наименование потока, выполняющего
            // callable задачу
            result = calculator.calcFactorial( arg );
        }
        System.out.println( "Thread.currentThread().getName()222 = " + Thread.currentThread().getName() );
        return result;
    }
}