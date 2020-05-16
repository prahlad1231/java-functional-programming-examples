package streams;

import declarative.Demo;

import javax.xml.namespace.QName;
import java.util.List;
import java.util.stream.Collectors;

import static streams._Stream.Gender.*;

public class _Stream {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Prahlad", MALE, 23),
                new Person("Pranav", MALE, 15),
                new Person("Sita", FEMALE, 48),
                new Person("Aayush", MALE, 27),
                new Person("Shreena", FEMALE, 23),
                new Person("Mark", MALE, 37)
        );

        // extract all males
        System.out.println("List of all males: ");
        people.stream()
                .filter(person -> person.gender.equals(MALE))
                .forEach(person -> System.out.println(person.toString()));

        // check if the list contains any females
        boolean containsFemale = people.stream()
                .anyMatch(person -> FEMALE.equals(person.gender));
        System.out.println("\nContains female: " + containsFemale);

        // extract all person having age in between 20 and 30
        List<Person> ageBetween20And30 = people.stream()
                .filter(person -> person.age > 20 && person.age < 30)
                .collect(Collectors.toList());

        System.out.println("\nAge between 20 and 30: " + ageBetween20And30.toString());

        // print the names of all person who are female
        System.out.println("\nNames of all females: ");
        people.stream()
                .filter(person -> person.gender.equals(FEMALE))
                .map(person -> person.name)
                .forEach(System.out :: println);

        // extract males whose age is between 20 and 30 and name starts from P
        System.out.println("\nPerson who is male, whose name starts with P and age is between 20 and 30: ");
        people.stream()
                .filter(person -> person.gender.equals(MALE))
                .filter(person -> person.name.startsWith("P"))
                .filter(person -> person.age > 20 && person.age < 30)
                .forEach(System.out :: println);

    }

    static class Person {
        private final String name;
        private final Gender gender;
        private final int age;

        public Person(String name, Gender gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person { Name = " + name +
                    ", Gender = " + gender + ", Age = " + age + "}";
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
