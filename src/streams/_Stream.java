package streams;

import declarative.Demo;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Prahlad", MALE),
                new Person("Pranav", MALE),
                new Person("Sita", FEMALE),
                new Person("Aayush", MALE),
                new Person("Shreena", FEMALE),
                new Person("Applia", OTHER)
        );

        /*people.stream()
                .map(person -> person.name)
                .mapToInt(String::length)
                .forEach(System.out::println);*/

        boolean containsFemale = people.stream()
                .noneMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsFemale);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person { name = " + name +
                    ", Gender = " + gender + "}";
        }
    }

    enum Gender {
        MALE, FEMALE, OTHER
    }
}
