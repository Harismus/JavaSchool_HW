package com.company;

public class Person {
    public Person(boolean man, String name) {
        this.man = man;
        this.name = name;
    }

    /**
     * This method checks gender of persons. If genders are not equal - tries to marry.
     * If one of them has another spouse - execute divorce(sets spouse = null for husband and wife. Example: if both persons have spouses - then divorce will set 4 spouse to null) and then executes marry().
     *
     * @param person - new husband/wife for this person.
     * @return - returns true if this person has another gender than passed person and they are not husband and wife, false otherwise
     */
    public boolean marry(Person person) {
        if (person == null) {
            return false;
        }

        if (man != person.man) {
            if (spouse != null) {
                this.divorce();
            }

            if (person.spouse != null) {
                person.divorce();
            }

            spouse = person;
            person.spouse = this;

            return true;
        }
        return false;
    }

    /**
     * Sets spouse = null if spouse is not null
     *
     * @return true - if person status has been changed
     */
    public boolean divorce() {
        boolean isNotNull = (spouse != null);
        if (isNotNull) {
            System.out.println(name + " is divorce with " + spouse.getName() + " now");
            spouse.spouse = null;
            spouse = null;
        }

        return isNotNull;
    }

    public Person getSpouse() {
        return spouse;
    }

    public String getName() {
        return name;
    }

    public boolean getMan() {
        return man;
    }


    private final boolean man;
    private final String name;
    private Person spouse;
}