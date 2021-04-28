package com.Task7;

public class Man implements Person{
    private int id;
    private String name;
    private Gender gender = Gender.Man;

    Man() {
        this.name = "default";
        this.id = -1;
    }

    Man(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString () {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", gender=" + this.getGender () + '\'' +
                '}';
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
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
