package service;

import consts.Gender;
import model.AddressBook;
import model.Person;

import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Optional;

public class AddressBookService {
    AddressBook addressBook;

    public AddressBookService(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Returns the count of a particular gender
     * @param gender MALE or FEMALE
     * @return the count
     */
    public long genderCount(Gender gender) {
        long count = this.addressBook.getPeople().stream()
                .filter(person -> person.getGender() == gender).count();
        return count;
    }

    public Optional<Person> eldestPerson() {
        Optional<Person> eldestPerson = this.addressBook.getPeople().stream().max(new SortByAge());
        return eldestPerson;
    }

    public long daysOlder(Person personA, Person personB) {
        long daysBetween = ChronoUnit.DAYS.between(personA.getDob(), personB.getDob());
        return daysBetween;
    }

}

class SortByAge implements Comparator<Person> {
    public int compare(Person a, Person b) {
        if (a.getDob().isBefore(b.getDob())) {
            return 1;
        } else if (b.getDob().isBefore(a.getDob())) {
            return -1;
        } else {
            return 0;
        }
    }
}
