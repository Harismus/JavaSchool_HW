import calculator.Calculator;
import calculator.CalculatorImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {


    public static void main(String[] args) {
        // Определяем пул из трех потоков
        ExecutorService executor = Executors.newFixedThreadPool( 3 );

        // Список ассоциированных с Callable задач Future
        List<Future<Integer>> futures = new ArrayList<>();

        // Создание экземпляра Callable класса

        Calculator calculator = new CalculatorImpl();

        List<Callable<Integer>> listCallable = new ArrayList<>();
        listCallable.add( new CallableClass(calculator, 3) );
        listCallable.add( new CallableClass(calculator, 4) );
        listCallable.add( new CallableClass(calculator, 5) );

        for (int i = 0; i < 3; i++) {
            /*
             * Стартуем возвращаюший результат исполнения
             * в виде объекта Future поток
             */
            System.out.println(i);
            Future<Integer> future = executor.submit( listCallable.get( i ) );
            /*
             * Добавляем объект Future в список для
             * отображения результат выполнения (получение
             * наименования потока)
             */
            futures.add( future );
        }


        for (Future<Integer> future : futures) {
            try {
                // Выводим в консоль полученное значение

                Integer result = future.get();
                System.out.println( result );
            } catch (InterruptedException |
                    ExecutionException e) {
            }
        }


        for (Future<Integer> future : futures) {
            try {
                // Выводим в консоль полученное значение

                Integer result = future.get();
                System.out.println( result );
            } catch (InterruptedException |
                    ExecutionException e) {
            }
        }
        
        // Останавливаем пул потоков
        executor.shutdown();
        
    }
}
