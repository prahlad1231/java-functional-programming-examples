package streams.practice;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String[] args) {
        List<Person> people = getPeople();

        // filter
        List<Person> males = people.stream()
                .filter(person -> person.getGender().equals(Gender.MALE))
                .collect(Collectors.toList());

//        males.stream().forEach(System.out :: println);

        // sort
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());

//        sortedByAge.forEach(System.out :: println);

        // all match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 18);

//        System.out.println(allMatch);

        // any match
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 30);

//        System.out.println(anyMatch);

        // none match
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Prahlad"));

//        System.out.println(noneMatch);

        // max
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out :: println);

        // min
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out :: println);

        // group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(System.out :: println);
            System.out.println();
        });

        // grab the oldest female
        people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out :: println);

        // grab the oldest female and return her name
        Optional<String> oldestFemale = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);

        oldestFemale.ifPresent(System.out :: println);
    }

    public static List<Person> getPeople() {
        return List.of(
                new Person("Prahlad", 22, Gender.MALE),
                new Person("Pranav", 14, Gender.MALE),
                new Person("Sita", 45, Gender.FEMALE),
                new Person("Richa", 20, Gender.FEMALE),
                new Person("Chandra", 45, Gender.MALE)
        );
    }
}
