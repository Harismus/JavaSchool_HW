import calculator.CalculatorImpl;
import thread.*;
import tasks.TestTask;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ExecutionManager executionManager = new ExecutionManagerImpl();

      List<Runnable> arrayThread = new ArrayList<>();
      Runnable callBack = new TestTask(new CalculatorImpl(), 5);

        for (int i = 1; i < 5; i++) {
            arrayThread.add( new TestTask(new CalculatorImpl(), i) );
        }
       Context context =  executionManager.execute(callBack,  arrayThread );


    }
}
