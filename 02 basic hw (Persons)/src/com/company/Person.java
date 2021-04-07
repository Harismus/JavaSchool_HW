package com.company;

public class Person {
    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    public Person getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public boolean getMan() {
        return man;
    }

    private final boolean man;
    private final String name;
    private Person spouse;
}