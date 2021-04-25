package com.Task5;

import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements Server {
    private List<Person> listPersons = new ArrayList<>();

    public void add(Person person) {
        if (!listPersons.contains( person ))
            listPersons.add( person );
    }

    public Person get(int id) {
        Person result = null;
        for (Person person : listPersons) {
            if (person.getId() == id) {
                result = person;
                break;
            }
        }
        return result;
    }

}
