package model;

public class ContactData {
    private final String name;
    private final String surname;
    private final String year;

    public ContactData(String name, String surname, String year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getYear() {
        return year;
    }
}
