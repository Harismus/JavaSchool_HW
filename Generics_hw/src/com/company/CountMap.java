package com.company;

import java.util.List;
import java.util.Map;

public interface CountMap<T> {

    /**
     * добавляет элемент в этот контейнер.
     *
     * @param o
     */
    void add(T o);


    /**
     * Возвращает количество добавлений данного элемента
     *
     * @param o
     * @return
     */
    int getCount(T o);

    /**
     * Удаляет элемент и контейнера и возвращает количество его добавлений(до удаления)
     *
     * @param o
     * @return
     */
    int remove(T o);

    /**
     * количество разных элементов
     *
     * @return
     */
    int size();

    /**
     * Добавить все элементы из source в текущий контейнер,
     * при совпадении ключей, суммировать значения
     *
     * @param source
     */
    void addAll(CountMap<T> source);

    /**
     * Вернуть java.util.Map.ключ - добавленный элемент,
     * значение - количество его добавлений
     *
     * @return
     */
    Map<T, Integer> toMap();

    /**
     * Тот же самый контракт как и toMap(), только всю информацию записать в destination
     *
     * @param destination
     */
    void toMap(Map<T, Integer> destination);
}