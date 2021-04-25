package com.Task2;

public class Child extends Parent {
    private int privateFieldChild;
    public int publicFieldChild;


    private void funcPrivateChild() {
        System.out.println( " funcPrivateChild" );
    }


    public void funcPublicChild() {
        System.out.println( " funcPublicChild" );
    }
}
