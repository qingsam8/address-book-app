package service;

import consts.Gender;
import factory.AddressBookFactory;
import model.AddressBook;
import model.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;

public class TestAddressBookService {


    AddressBookService addressBookService;

    @Before
    public void before() {
        URL resource = getClass().getClassLoader().getResource("AddressBook.txt");

        AddressBook addressBook = AddressBookFactory.addressBookFromFile(resource.getPath());
        addressBookService = new AddressBookService(addressBook);
    }

    @Test
    public void testGenderCount() {
        long actualNumOfMale = addressBookService.genderCount(Gender.MALE);
        long expectedNumOfMale = 3;
        Assert.assertEquals(actualNumOfMale, expectedNumOfMale);

        long actualNumOfFemale = addressBookService.genderCount(Gender.FEMALE);
        long expectedNumOfFemale = 2;
        Assert.assertEquals(actualNumOfFemale, expectedNumOfFemale);
    }

    @Test
    public void testGenderCount_withEmptyPeople() {
        AddressBookService addressBookService = new AddressBookService(new AddressBook());

        long actualNumOfMale = addressBookService.genderCount(Gender.MALE);
        long expectedNumOfMale = 0;
        Assert.assertEquals(actualNumOfMale, expectedNumOfMale);

        long actualNumOfFemale = addressBookService.genderCount(Gender.FEMALE);
        long expectedNumOfFemale = 0;
        Assert.assertEquals(actualNumOfFemale, expectedNumOfFemale);
    }

    @Test
    public void testEldestPerson() {
        Optional<Person> actual = addressBookService.eldestPerson();
        Person expected = new Person("wes", "jackson", Gender.MALE, LocalDate.of(2074,8, 14));

        Assert.assertEquals(actual, Optional.of(expected));
    }

    @Test
    public void testEldestPerson_withEmptyList() {
        AddressBookService addressBookService = new AddressBookService(new AddressBook());

        Optional<Person> actual = addressBookService.eldestPerson();
        Optional<Person> expected = Optional.empty();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testDaysOlder_withYoungerPerson() {
        Person personA = new Person("wes", "jackson", Gender.MALE, LocalDate.of(2074,8, 14));
        Person personB = new Person("Ann", "jackson", Gender.MALE, LocalDate.of(2075,8, 14));

        long actual = addressBookService.daysOlder(personA, personB);
        long expected = 365;

        Assert.assertEquals(actual, expected);
    }


    @Test
    public void testDaysOlder_withOlderPerson() {
        Person personA = new Person("Ann", "jackson", Gender.MALE, LocalDate.of(2075,8, 14));
        Person personB = new Person("wes", "jackson", Gender.MALE, LocalDate.of(2074,8, 14));

        long actual = addressBookService.daysOlder(personA, personB);
        long expected = -365;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void testDaysOlder_withSameDate() {
        Person personA = new Person("wes", "jackson", Gender.MALE, LocalDate.of(2074,8, 14));
        Person personB = new Person("Ann", "jackson", Gender.MALE, LocalDate.of(2074,8, 14));

        long actual = addressBookService.daysOlder(personA, personB);
        long expected = 0;

        Assert.assertEquals(actual, expected);
    }
}
