package com.Task6;


import java.lang.reflect.Proxy;

public class PerformanceProxy implements Calculator{
    private Calculator delegate;
    private Calculator calc;

    PerformanceProxy(Calculator calculator) {

        delegate = calculator;

        //Получаем загрузчик класса у оригинального объекта
        ClassLoader serverClassLoader = delegate.getClass().getClassLoader();

        //Получаем все интерфейсы, которые реализует оригинальный объект
        Class[] interfaces = delegate.getClass().getInterfaces();

        //Создаем прокси нашего объекта
        calc = (Calculator) Proxy.newProxyInstance( serverClassLoader, interfaces, new CalculatorInvocationHandler( delegate ) );
    }

    @Override
    public int calc(int number) {
        return   calc.calc(number);
    }
};


