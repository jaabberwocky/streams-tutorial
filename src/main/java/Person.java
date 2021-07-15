public class Person {
    private String name;
    private int age;
    private Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("Person{name: %s, age: %s, gender: %s}", this.name, this.age, this.gender);
    }
}