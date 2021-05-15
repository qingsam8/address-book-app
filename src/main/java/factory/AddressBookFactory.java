package factory;

import consts.Gender;
import model.AddressBook;
import model.Person;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Stream;

/**
 * Factory to create an address book
 */
public class AddressBookFactory {

    // TODO date use 19th century or even better, update the dataset to contain YYYY instead of YY
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yy");

    private static Person parsePerson(String line) {
        System.out.println(line);
        String[] lineArr = line.toLowerCase().split("\\s*,\\s*");

        String[] names = lineArr[0].split(" ");
        String firstName = names[0].trim();
        String surName = names[1].trim();

        Gender gender = Gender.fromString(lineArr[1]);


        LocalDate date = LocalDate.parse(lineArr[2], AddressBookFactory.formatter);
        return new Person(firstName, surName, gender, date);
    }

    public static AddressBook addressBookFromFile(String filePath) {
        File file = new File(filePath);

        if(!file.exists()) {
            throw new IllegalArgumentException();
        }

        Set<Person> people = new HashSet<>(); // Store the person

        // read file line by line and update people Set with Person
        try (Stream<String> stream = Files.lines(Paths.get(file.getAbsolutePath()))) {

            stream.forEach(line -> {
                Person person = parsePerson(line);
                people.add(person);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new AddressBook(people);
    }
}
