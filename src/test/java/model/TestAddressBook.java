package model;

import consts.Gender;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;

public class TestAddressBook {

    @Test
    public void testEqual_withEmptyPerson() {
        boolean actual = new AddressBook().equals(new AddressBook());
        Assert.assertTrue(actual);
    }

    @Test
    public void testEqual_withIdenticalPeson() {
        AddressBook addressBookA = new AddressBook(new HashSet<>(Arrays.asList(
                new Person("bill", "mcknight", Gender.MALE, LocalDate.of(2077,3, 16)),
                new Person("paul", "robinson", Gender.MALE, LocalDate.of(2085,1, 15))
        )));
        AddressBook addressBookB = new AddressBook(new HashSet<>(Arrays.asList(
                new Person("bill", "mcknight", Gender.MALE, LocalDate.of(2077,3, 16)),
                new Person("paul", "robinson", Gender.MALE, LocalDate.of(2085,1, 15))
        )));

        boolean actual = addressBookA.equals(addressBookB);

        Assert.assertTrue(actual);
    }

    @Test
    public void testEqual_withNoneIdenticalPeson() {
        AddressBook addressBookA = new AddressBook(new HashSet<>(Arrays.asList(
                new Person("abc", "def", Gender.MALE, LocalDate.of(2077,3, 16)),
                new Person("paul", "robinson", Gender.MALE, LocalDate.of(2085,1, 15))
        )));
        AddressBook addressBookB = new AddressBook(new HashSet<>(Arrays.asList(
                new Person("bill", "mcknight", Gender.MALE, LocalDate.of(2077,3, 16)),
                new Person("paul", "robinson", Gender.MALE, LocalDate.of(2085,1, 15))
        )));

        boolean actual = addressBookA.equals(addressBookB);

        Assert.assertFalse(actual);
    }
}
