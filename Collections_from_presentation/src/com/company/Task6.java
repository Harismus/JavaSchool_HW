package com.company;

import java.util.List;
import java.util.Scanner;

/**
 * Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
 */
public class Task6 extends AbstractTask {
    public static void Do(String buffer) {
        System.out.println( "================Task6==================" );
        List<String> lines = ArrayCast.from( buffer, "\\n" );

        if (lines.isEmpty()) {
            System.out.println( "Файл с данными пустой" );
            return;
        }
        Scanner scanner = new Scanner( System.in );
        System.out.print( "Введите номер строки для вывода на экран от 0 до " + (lines.size() - 1) + " :" );
        int number = scanner.nextInt();

        if (lines.size() > number) {
            System.out.println( "str number  = " + number + ":" );
            System.out.println( lines.get( number ) );
        }
        else {
            System.out.println( "Выход за пределы массива" );
        }
    }
}
