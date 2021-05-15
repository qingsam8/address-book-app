package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AddressBook {
    private Set<Person> people;

    public AddressBook(Set<Person> people) {
        this.people = people;
    }

    public AddressBook() {
        this.people = new HashSet<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressBook that = (AddressBook) o;
        return Objects.equals(people, that.people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(people);
    }

    public Set<Person> getPeople() {
        return people;
    }
}
