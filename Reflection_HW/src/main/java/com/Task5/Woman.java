package com.Task5;

public class Woman implements Person{
    private int id;
    private String name;
    private Gender gender = Gender.Woman;

    Woman(String name, int id) {
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
