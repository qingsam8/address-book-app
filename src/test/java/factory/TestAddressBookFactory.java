package factory;

import consts.Gender;
import model.AddressBook;
import model.Person;
import org.junit.Test;

import java.net.URL;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class TestAddressBookFactory {

    @Test
    public void testAddressBookFromFile_withValidFile_thenExpectCorrectAddressBook() {
        URL resource = getClass().getClassLoader().getResource("AddressBook.txt");

        AddressBook actual = AddressBookFactory.addressBookFromFile(resource.getPath());


        List<Person> people = Arrays.asList(
                new Person("bill", "mcknight", Gender.MALE, LocalDate.of(2077,3, 16)),
                new Person("paul", "robinson", Gender.MALE, LocalDate.of(2085,1, 15)),
                new Person("gemma", "lane", Gender.FEMALE, LocalDate.of(2091,11, 20)),
                new Person("sarah", "stone", Gender.FEMALE, LocalDate.of(2080,9, 20)),
                new Person("wes", "jackson", Gender.MALE, LocalDate.of(2074,8, 14))
        );
        AddressBook expected = new AddressBook(new HashSet<>(people));

        assert actual.equals(expected);

    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddressBookFromFile_withInvalidFile_thenExpectIllegalArgumentException() {
        AddressBookFactory.addressBookFromFile("abcd");
    }
}
