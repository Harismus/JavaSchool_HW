package com.company;

import com.company.Person;


public class Main {

    public static void main(String[] args) {

        Person Alex = new Person(true, "Alex");
        Person Eduard = new Person(true, "Eduard");
        Person Ivan = new Person(true, "Ivan");

        Person Maria = new Person(false, "Maria");
        Person Ann = new Person(false, "Ann");
        Person Kate = new Person(false, "Kate");



        if (Alex.marry(Maria))
            System.out.println(Alex.getName() + " has married with " + Maria.getName());
        else
            System.out.println(Alex.getName() + " and "  + Maria.getName() + " have same gender");

        if (Ann.marry(Eduard))
            System.out.println(Ann.getName() + " has married with " + Eduard.getName());
        else
            System.out.println(Ann.getName() + " and "  + Eduard.getName() + " have same gender");

        if (Ann.marry(Alex))
            System.out.println(Ann.getName() + " has married with " + Alex.getName());
        else
            System.out.println(Ann.getName() + " and "  + Alex.getName() + " have same gender");

        if (Ivan.marry(Eduard))
            System.out.println(Ivan.getName() + " has married with " + Eduard.getName());
        else
            System.out.println(Ivan.getName() + " and "  + Eduard.getName() + " have same gender");

        if (Ivan.marry(Kate))
            System.out.println(Ivan.getName() + " has married with " + Kate.getName());
        else
            System.out.println(Ivan.getName() + " and "  + Kate.getName() + " have same gender");

    }
}
