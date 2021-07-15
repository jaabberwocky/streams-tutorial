import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> persons = createList();
        printPersonList(persons, "All Persons");

        // filter
        List<Person> females = persons.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        printPersonList(females, "Females");

        // grouping
        // note - creates a map based on the grouping col
        Map<Gender, List<Person>> p = persons.stream()
                .collect(Collectors.groupingBy(Person::getGender));
        System.out.println(p);

        // all match
        boolean allMatch = persons.stream()
                .allMatch(person -> person.getAge() > 99);
        System.out.println(allMatch);

        // none match
        boolean noneMatch = persons.stream()
                .noneMatch(person -> person.getAge() < 4);
        System.out.println(noneMatch);

        // max
        persons.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        // min
        persons.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
    }

    private static List<Person> createList() {
        return List.of(
                new Person("James Bond", 41, Gender.MALE),
                new Person("Mary Jane", 55, Gender.FEMALE),
                new Person("Sarah Thompson", 12, Gender.FEMALE),
                new Person("Jimmy Thorne", 16, Gender.MALE),
                new Person("Katherine Hope", 4, Gender.FEMALE),
                new Person("John Hunter", 98, Gender.MALE)
        );
    }

    private static void printPersonList(List<Person> list, String descriptor) {
        System.out.println("\n" + descriptor + ":");
        list.forEach(System.out::println);
    }
}
