package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.Integer;

public class CollectionUtils {
    /**
     * @param source
     * @param destination
     * @param <T>
     */
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll( source );
    }

    /**
     * создание новой коллекции
     *
     * @param <T>
     * @return
     */
    public static <T> List<? super T> newArrayList() {
        return new ArrayList<T>();
    }

    /*
     * возвращает индекс первого вхождения объекта obj в список. Если объект не найден, то возвращается -1
     * @param source
     * @param o
     * @param <T>
     * @return
     */
    public static <T> int indexOf(List<? extends T> source, T obj) {
        return source.indexOf( obj );
    }

    /**
     * применяется для выборки первых n элементов потоков
     *
     * @param source
     * @param size
     * @return
     */
    public static <T> List<T> limit(List<? extends T> source, int size) {
        return source.stream().limit( size ).collect( Collectors.toList() );
    }

    /**
     * добавление элемента в список
     *
     * @param source
     * @param obj
     */
    public static <T> void add(List<? super T> source, T obj) {
        source.add( obj );
    }

    /**
     * @param removeFrom
     * @param dest
     */
    public static <T> void removeAll(List<? super T> removeFrom, List<T> dest) {
        removeFrom.removeAll( dest );
    }

    /**
     * true если первый лист содержит все элементы второго
     *
     * @param c1
     * @param c2
     * @return
     */
    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2) {
        return c1.containsAll( c2 );
    }

    /**
     * true если первый лист содержит хотя-бы 1 второго
     *
     * @param c1
     * @param c2
     * @return
     */
    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2) {
        return c1.contains( c2 );
    }

    /**
     * //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
     * // Элементы сравнивать через Comparable.
     * // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
     *
     * @param list
     * @param min
     * @param max
     * @return
     */
    public static List<java.lang.Integer> range(List<? extends java.lang.Integer> list, java.lang.Integer min, java.lang.Integer max) {
        List<Integer> listRanged = new ArrayList<>();

        for (Integer obj : list) {
            if ((obj >= min) && (obj <= max))
                listRanged.add( obj );
        }
        return listRanged;
    }

    /**
     * //Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
     * // Элементы сравнивать через Comparable.
     * // Прмер range(Arrays.asList(8,1,3,5,6, 4), 3, 6) вернет {3,4,5,6}
     *
     * @param list
     * @param min
     * @param max
     * @param comparator
     * @return
     */
    public static List<java.lang.Integer> range(List<? extends java.lang.Integer> list, java.lang.Integer min, java.lang.Integer max, Comparator<java.lang.Integer> comparator) {

        List<Integer> listRanged = new ArrayList<>();

        for (Integer obj : list) {
            if ((comparator.compare( obj, min ) >= 0) && (comparator.compare( obj, max ) <= 0))
                listRanged.add( obj );
        }
        return listRanged;
    }
}
