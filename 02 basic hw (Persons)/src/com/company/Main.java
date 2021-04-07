package com.company;


public class Main {

    public static void main(String[] args) {

        Person Alex = new Person(true, "Alex");
        Person Eduard = new Person(true, "Eduard");
        Person Ivan = new Person(true, "Ivan");

        Person Maria = new Person(false, "Maria");
        Person Ann = new Person(false, "Ann");
        Person Kate = new Person(false, "Kate");

        attemptToMarry(Alex, Maria);
        attemptToMarry(Ann, Eduard);
        attemptToMarry(Ann, Alex);
        attemptToMarry(Ivan, Eduard);
        attemptToMarry(Ivan, Kate);
    }

    static void attemptToMarry(Person person1, Person person2)
    {
        if (person1.marry(person2))
            System.out.println(person1.getName() + " is married with " + person2.getName() + " now");
        else
            System.out.println(person1.getName() + " and "  + person2.getName() + " have same gender");
    }
}
