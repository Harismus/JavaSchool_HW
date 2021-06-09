package com.sbr.jdbc.dao;

import com.sbr.jdbc.model.Person;

import java.util.Set;

/**
 * Работа с человеком
 */
public interface PersonDao {
    /**
     * Найти человека по id
     * @param personId id человека
     * @return человек
     */
    Person findPersonById(int personId);

    /**
     * Создть человека
     * @param name имя
     * @param age возраст
     * @return человек
     */
    Person createPerson(String name, int age);

    /**
     * Получить всех людей
     * @return люди
     */
    Set<Person> getPersons();
}
