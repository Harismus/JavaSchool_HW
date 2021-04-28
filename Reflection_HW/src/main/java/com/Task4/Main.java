package com.Task4;


import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        TestClass testClass = new TestClass();

        for (Field field : testClass.getClass().getFields()) {
            System.out.println( "field.getName() = " + field.getName() );
            try {
                System.out.println( "field value = " + field.get( testClass ) );

                if (field.getName().equals( field.get( testClass ))) {
                    System.out.println( "filed and value are equals" );
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }


        }
    }
}