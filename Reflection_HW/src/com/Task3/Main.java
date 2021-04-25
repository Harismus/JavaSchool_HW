package com.Task3;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        for (Method method : testClass.getClass().getDeclaredMethods())
        {
            if(method.getName().startsWith( "get" ))
                System.out.println( method.getName());


        }
    }
}
