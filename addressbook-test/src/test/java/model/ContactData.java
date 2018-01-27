package model;

import java.util.Objects;

public class ContactData {
    private String name;
    private String surname;
    private String year;


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getYear() {
        return year;
    }

    public ContactData withName(String name) {
        this.name = name;
        return this;
    }

    public ContactData withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public ContactData withBirthYear(String year) {
        this.year = year;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData = " +
                "name: " + name +
                ", surname: " + surname+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(surname, that.surname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, surname, year);
    }
}
