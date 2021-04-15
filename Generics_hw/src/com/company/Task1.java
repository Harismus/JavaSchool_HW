package com.company;

/**
 * 1.	Параметризовать CountMap (из репозитория выше) и реализовать его
 **/
public class Task1 {
    static void Do() {
        CountMap<Integer> map = new CountMapImpl<>();

        map.add( 10 );
        map.add( 10 );
        map.add( 5 );
        map.add( 6 );
        map.add( 5 );
        map.add( 10 );

        int countNumber5 = map.getCount( 5 );  // 2
        int countNumber6 = map.getCount( 6 );  // 1
        int countNumber10 = map.getCount( 10 ); // 3

        System.out.println( "countNumber10 = " + countNumber10 );
        System.out.println( "countNumber6 = " + countNumber6 );
        System.out.println( "countNumber5 = " + countNumber5 );
    }
}
