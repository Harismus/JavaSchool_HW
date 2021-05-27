import calculator.Calculator;
import calculator.CalculatorImpl;
import tasks.Task;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Calculator calculator = new CalculatorImpl();

        List<Task<Integer>> listTasks = new ArrayList<>();
        listTasks.add( new Task<>( new CallableClass( calculator, 3 ) ) );
        listTasks.add( new Task<>( new CallableClass( calculator, 0 ) ) );
        listTasks.add( new Task<>( new CallableClass( calculator, 5 ) ) );
        listTasks.add( new Task<>( new CallableClass( calculator, 6 ) ) );


        try {
            for (int i = 0; i < listTasks.size(); i++) {
                Integer result = listTasks.get( i ).get();
                System.out.println( "result = " + result );
            }


        }
        catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
