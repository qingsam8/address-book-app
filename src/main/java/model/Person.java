package model;

import consts.Gender;

import java.util.Date;

public class Person {
    private String firstName;
    private String surname;
    private Gender gender;
    private Date dob;

    public Person(String firstName, String surname, Gender gender, Date dob) {
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

    public Date getDob() {
        return dob;
    }
}
