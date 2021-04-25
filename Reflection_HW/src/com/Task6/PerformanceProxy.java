package com.Task6;

import com.Task5.ServerInvocationHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PerformanceProxy extends Proxy {
    private Calculator delegate;

    PerformanceProxy(Calculator calculator) {
        super( new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return null;
            }
        } );
        InvocationHandler invovation = new CalculatorInvocationHandler( delegate );
        delegate = new CalculatorImpl();

        //Получаем загрузчик класса у оригинального объекта
        ClassLoader serverClassLoader = delegate.getClass().getClassLoader();

        //Получаем все интерфейсы, которые реализует оригинальный объект
        Class[] interfaces = delegate.getClass().getInterfaces();

        //Создаем прокси нашего объекта
        newProxyInstance( serverClassLoader, interfaces, new CalculatorInvocationHandler( delegate ) );

//        System.out.println( "proxyCalculator = " + proxyCalculator.calc(15 ));
    }


};


