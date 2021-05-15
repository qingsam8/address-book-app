package model;

import consts.Gender;

import java.time.LocalDate;
import java.util.Objects;

public class Person {
    private String firstName;
    private String surname;
    private Gender gender;
    private LocalDate dob;

    public Person(String firstName, String surname, Gender gender, LocalDate dob) {
        this.firstName = firstName;
        this.surname = surname;
        this.gender = gender;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(surname, person.surname) &&
                gender == person.gender &&
                Objects.equals(dob, person.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, surname, gender, dob);
    }


}
