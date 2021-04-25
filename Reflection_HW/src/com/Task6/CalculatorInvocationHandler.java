package com.Task6;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorInvocationHandler implements InvocationHandler {
    private Object delegate;


    public CalculatorInvocationHandler(Object delegate) {
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (!method.isAnnotationPresent( Metric.class )) {
            method.invoke( delegate, args );
        }
        System.out.println( "Метод " + method.getName() + " вызван" );

        long before = System.currentTimeMillis();
        Object invoke = method.invoke( delegate, args );
        long after = System.currentTimeMillis();

        System.out.println( "Метод " + method.getName() + " вызван. Время выполнения = " + (after - before)*1000 + " наносек.");

        return invoke;
    }
}
