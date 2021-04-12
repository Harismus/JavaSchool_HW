package com.company;


import java.util.List;
import java.util.function.Function;

/*Имеется список парка машин Car(String model, String type). Необходимо разбить его на списки сгруппированные по type.
Пример исходного списка: Лада седан, Лада хэтчбек, Мерседес седан, Бмв кроссовер,  Форд хэтчбек, Пежо кроссовер, Тойота седан и т.п.
*/
public class Main {

    @FunctionalInterface
    public interface CheckedFunction<T, R> {
        R apply(T t) throws Exception;
    }

    public static void main(String[] args) {
        ListCarManager listCarManage = new ListCarManager();

        CheckedFunction<String, List<Car>> getAndPrintSubList = type -> {
            List<Car> subList = listCarManage.getSubList(type);

            if (subList.isEmpty())
                throw new Exception("The list of cars has not such type car how " +  type);

            subList.forEach(car -> System.out.println("Model = " + car.getModel() + " type = " + car.getType()));

            return subList;
        };


        try {
            List<Car> listCrossOver = getAndPrintSubList.apply("Кроссовер");
            List<Car> listSedan = getAndPrintSubList.apply("Седан");
            List<Car> listHatchback = getAndPrintSubList.apply("Хэтчбек");
            List<Car> listUniversal = getAndPrintSubList.apply("Универсал");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
