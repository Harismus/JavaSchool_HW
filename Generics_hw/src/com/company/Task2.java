package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 2.	Параметризовать методы, используя правило PECS, и реализовать их.
 **/


public class Task2 {




    static void Do() {

        list = new ArrayList<>();
        fillArray(list);

        List<Integer> newList = testNewArray();
        testAddAll(list, newList);
        testIndexOf(list, 6);
        testLimit(list, 4);
        testAdd(list, 2);
        testRemoveAll();

        List<Integer> list2 = new ArrayList<>(list);
        testContainsAll(list, list2);

        testRange(list, 10, 20);


        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };

        testCompareRange(list, 10, 20, comparator);



    }

    private static List<Integer> list;

    private static void fillArray(List<Integer> list)
    {
        list.add( 21 );
        list.add( 60 );
        list.add( 3 );
        list.add( 66 );
        list.add( 12 );
        list.add( 15 );
        list.add( 6 );
        list.add( 19 );
        list.add( 20 );
        list.add( 56 );
        list.add( 6 );
    }

    private static List<Integer> testNewArray()
    {
        System.out.println("****************************************************************************");
        System.out.println( "Task2.testNewArray" );
        List<Integer> newList = (List<Integer>) CollectionUtils.<Integer>newArrayList();

        newList.add( 1 );
        newList.add( 2 );
        System.out.println( "newList = " + newList );
        return newList;
    }

    private static void testAddAll(List<Integer> source, List<Integer> destination )
    {
        System.out.println("****************************************************************************");
        System.out.println( "Task2.testAddAll" );
        CollectionUtils.<Integer>addAll(source, destination);
        System.out.println( "destination = " + destination );
    }

    private static void testRemoveAll()
    {
        System.out.println("****************************************************************************");
        System.out.println( "Task2.testRemoveAll" );
        List<Integer> removeFrom = new ArrayList<>();
        removeFrom.add( 1 );
        removeFrom.add( 3 );
        removeFrom.add( 5 );
        removeFrom.add( 2 );

        List<Integer> destination = new ArrayList<>();
        destination.add( 3 );
        destination.add( 2 );

        CollectionUtils.<Integer>removeAll(removeFrom, destination);
        System.out.println( "removeFrom = " + removeFrom );
    }

    private static void testIndexOf(List<Integer> list, Integer obj )
    {
        System.out.println("****************************************************************************");
        System.out.println( "Task2.testIndexOf" );
        System.out.println( "CollectionUtils.indexOf 6 = " + CollectionUtils.<Integer>indexOf( list, obj ) );
    }

    private static void testLimit(List<Integer> list, Integer obj )
    {
        System.out.println("****************************************************************************");
        System.out.println( "Task2.testLimit" );
        System.out.println( "CollectionUtils.limit(list,4) = " + CollectionUtils.limit(list,obj) );
    }

    private static void testAdd(List<Integer> list, Integer obj )
    {
        System.out.println("****************************************************************************");
        System.out.println( "Task2.testAdd" );
        CollectionUtils.add( list, obj );
        System.out.println( "list = " + list );
    }

    private static void testContainsAll(List<Integer> list, List<Integer> list2)
    {
        System.out.println("****************************************************************************");
        System.out.println( "Task2.testContainsAll" );

        System.out.println( "list  containsAll = " + CollectionUtils.containsAll( list, list2 ) );

        list2.set( 0, 1 );
        System.out.println( "list after replace containsAll = " + CollectionUtils.containsAll( list, list2 ) );
    }

    private static void testRange(List<Integer> list, Integer min, Integer max)
    {
        System.out.println("****************************************************************************");
        System.out.println( "Task2.testRange" );

        List<Integer> listRange = CollectionUtils.range( list, min, max );
        System.out.println( "listRange = " + listRange );
    }

    private static void testCompareRange(List<Integer> list, Integer min, Integer max, Comparator<Integer> comparator)
    {
        System.out.println("****************************************************************************");
        System.out.println( "Task2.testCompareRange" );

        List<Integer> listCompareRange = CollectionUtils.range( list, 10, 20, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        } );


        System.out.println( "listCompareRange = " + listCompareRange );
    }
}
