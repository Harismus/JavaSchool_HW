package com.Task2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) {

        Child child = new Child();

        System.out.println("=========child=========");
        for(Method method : child.getClass().getDeclaredMethods())
        {
            method.setAccessible( true );
            try {

                System.out.println( "method.getName() = " + method.getName() );
                method.invoke( child );

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println("=========parent=========");
        for(Method method : child.getClass().getSuperclass().getDeclaredMethods())
        {
            method.setAccessible( true );
            try {
                System.out.println( "method.getName() = " + method.getName() );
                method.invoke( child );

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }
}
