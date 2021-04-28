package com.Task5;

public class Man implements Person{
    private int id;
    private String name;
    private Gender gender = Gender.Man;

    Man(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Gender getGender() {
        return gender;
    }
}
