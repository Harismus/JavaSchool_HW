import calculator.CalculatorImpl;
import thread.*;
import tasks.TestTask;

import java.util.*;
import java.util.concurrent.*;




public class Main {
    public static void main(String[] args) {

        ExecutionManager executionManager = new ExecutionManagerImpl();

        List<Runnable> arrayThread = new ArrayList<>();
        Runnable callBack = new TestTask( new CalculatorImpl(), 5 );

        for (int i = 0; i < 5; i++) {
            arrayThread.add( new TestTask( new CalculatorImpl(), i ) );
        }

        Context context = executionManager.execute( callBack, arrayThread );

        try {
            Thread.currentThread().sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int completedTaskCount = context.getCompletedTaskCount();
        System.out.println( "completedTaskCount = " + completedTaskCount );

        int failedTaskCount = context.getFailedTaskCount();
        System.out.println( "failedTaskCount = " + failedTaskCount );


        
    }
}
