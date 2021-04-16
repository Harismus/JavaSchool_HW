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
        destination.addAll(source);
    }

    /**
     * @param <T>
     * @return
     */
    public static <T> List<T> newArrayList() {
        return new ArrayList<T>();
    }

    /**
     * @param source
     * @param o
     * @param <T>
     * @return
     */
    public static <T> int indexOf(List<T> source, T o) {
        return source.indexOf(o);
    }

    /**
     * @param source
     * @param size
     * @return
     */
    public static <T> List<T> limit(List<T> source, int size) {
        return source.stream().limit(size).collect(Collectors.toList());
    }

    /**
     * @param source
     * @param o
     */
    public static <T> void add(List<T> source, T o) {
        source.add(o);
    }

    /**
     * @param removeFrom
     * @param c2
     */
    public static <T> void removeAll(List<T> removeFrom, List<T> c2) {
        removeFrom.removeAll(c2);
    }

    /**
     * true если первый лист содержит все элементы второго
     *
     * @param c1
     * @param c2
     * @return
     */
    public static <T> boolean containsAll(List<T> c1, List<T> c2) {
        return c1.containsAll(c2);
    }

    /**
     * true если первый лист содержит хотя-бы 1 второго
     *
     * @param c1
     * @param c2
     * @return
     */
    public static <T> boolean containsAny(List<T> c1, List<T> c2) {
        return c1.contains(c2);
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
    public static List<java.lang.Integer> range(List<java.lang.Integer> list, java.lang.Integer min, java.lang.Integer max) {
        List<Integer> listRanged = new ArrayList<>();

        for (Integer obj : list) {
            if ((obj >= min) && (obj <= max))
                listRanged.add(obj);
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
//    public static <T> List<T> range(List<T> list, T min, T max, Comparator<T> comparator) {
//        return list;
//    }
}
