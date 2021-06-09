package com.sbr.jdbc.dao;

import com.sbr.jdbc.connection.DataSourceHelper;
import com.sbr.jdbc.model.Animal;
import com.sbr.jdbc.model.Person;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class PersonDaoImpl implements PersonDao {

    @Override
    public Person createPerson(String name, int age) {
        try (PreparedStatement statement = DataSourceHelper.connection()
                .prepareStatement("insert into person (name, age) values (?, ?)")) {
            statement.setString(1, name);
            statement.setInt(2, age);
            statement.execute();

            return findPersonByName(name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person findPersonById(int id) {
        try (PreparedStatement statement = DataSourceHelper.connection()
                .prepareStatement("select * from person p where p.id=?")) {
            statement.setInt(1, id);
            statement.execute();

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return resultSetForPerson(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Person findPersonByName(String name) {
        try (PreparedStatement statement = DataSourceHelper.connection()
                .prepareStatement("select * from person p where p.name=?")) {
            statement.setString(1, name);
            statement.execute();

            ResultSet resultSet = statement.getResultSet();
            resultSet.next();

            return resultSetForPerson(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private Person resultSetForPerson(ResultSet resultSet) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt(1));
        person.setName(resultSet.getString(2));
        person.setAge(resultSet.getInt(3));

        try {
            int animalId = resultSet.getInt(4);

            if (animalId != 0) {
                String animalName = resultSet.getString(5);
                String animalType = resultSet.getString(6);

                Animal animal = new Animal();
                animal.setPerson(person);
                animal.setId(animalId);
                animal.setName(animalName);
                animal.setType(animalType);

                person.getAnimals().add(animal);
            }
        } catch (Exception e) {
        }

        return person;
    }

    @Override
    public Set<Person> getPersons() {
        try (Statement statement = DataSourceHelper.connection().createStatement()) {
            statement.execute("select * from person p left join animal a on p.id = a.person_id");
            ResultSet resultSet = statement.getResultSet();

            Set<Person> persons = new HashSet<>();
            while (resultSet.next()) {
                Person person = resultSetForPerson(resultSet);
                Optional<Person> anyPerson = persons.stream().filter(person::equals).findAny();


                if (anyPerson.isPresent()) {
                    anyPerson.get().getAnimals().addAll(person.getAnimals());
                } else {
                    persons.add(person);
                }
            }

            return persons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
