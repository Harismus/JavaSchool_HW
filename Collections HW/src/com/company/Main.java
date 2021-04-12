package com.company;

import java.util.ArrayList;
import java.util.List;

/*Имеется список парка машин Car(String model, String type). Необходимо разбить его на списки сгруппированные по type.
Пример исходного списка: Лада седан, Лада хэтчбек, Мерседес седан, Бмв кроссовер,  Форд хэтчбек, Пежо кроссовер, Тойота седан и т.п.
*/
public class Main {

    public static List<Car>  ListInitialization() {
        List<Car> listCars = new ArrayList<>();
        listCars.add(new Lada("Седан"));
        listCars.add(new Lada("Хетчбек"));
        listCars.add(new Mersedes("Седан"));
        listCars.add(new BMW("кроссовер"));
        listCars.add(new Ford("хэтчбек"));
        listCars.add(new Peugeot("кроссовер"));
        listCars.add(new Tayota("Седан"));

        return listCars;
    }

    public static void main(String[] args) {

        List<Car> listCars = ListInitialization();




    }
}
