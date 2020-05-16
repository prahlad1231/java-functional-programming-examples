package declarative;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static declarative.Demo.Gender.*;

public class Demo {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("Prahlad", MALE),
                new Person("Pranav", MALE),
                new Person("Sita", FEMALE),
                new Person("Aayush", MALE),
                new Person("Shreena", FEMALE)
        );

        // imperative approach
        /*List<Person> females = new ArrayList<>();

        for (Person person : people)
            if (FEMALE.equals(person.gender))
                females.add(person);

        for(Person female : females)
            System.out.println(female);*/

        // declarative approach
        people.stream().filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList()) // to collect result as a list
                .forEach(System.out :: println);

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
        MALE, FEMALE
    }
}
