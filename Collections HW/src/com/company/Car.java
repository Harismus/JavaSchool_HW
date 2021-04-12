package com.company;

public abstract class Car {
    private String type;
    private String model;

    Car(String model, String type)
    {
        this.model = model;
        this.type = type;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
