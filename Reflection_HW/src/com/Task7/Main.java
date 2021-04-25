package com.Task7;

public class Main {
    public static void main(String[] args) {
        Person Alex = new Man( "Alex", 3 );
        Person Ivan = new Man(  );

        System.out.println( "Alex = " + Alex.toString() );
        System.out.println( "Ivan before assign = " + Ivan.toString() );

        BeanUtils.assign( Ivan, Alex );

        System.out.println( "Ivan after assign = " + Ivan.toString() );

    }
}
