package com.company;

import java.util.ArrayList;
import java.util.List;

public class ListCarManager {

    static List<Car> listCars;

    ListCarManager() {
        ListInitialization();
    }

    public static void ListInitialization() {
        listCars = new ArrayList<>();
        listCars.add(new Lada("Седан"));
        listCars.add(new Lada("Хэтчбек"));
        listCars.add(new Mersedes("Седан"));
        listCars.add(new BMW("Кроссовер"));
        listCars.add(new Ford("Хэтчбек"));
        listCars.add(new Peugeot("Кроссовер"));
        listCars.add(new Tayota("Седан"));
    }

    public List<Car> getSubList(String type) {
        List<Car> subList = new ArrayList<>();
        for (com.company.Car Car : listCars) {
            if (Car.getType().equals(type))
                subList.add(Car);
        }

        return subList;

    }
}
