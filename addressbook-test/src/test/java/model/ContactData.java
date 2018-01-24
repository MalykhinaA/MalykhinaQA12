package model;

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
}
