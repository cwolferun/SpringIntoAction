package miscExamples;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

public class Person {
    private int age;
    private String name;
    private Sex gender;

    Person() {
    }

    public String getName() {
        return name;
    }

    Sex getGender() {
        return gender;
    }

    Person(int age, String name, Sex gender) {
        this.age = age;
        this.name = name;
        this.gender = gender;
    }

    public enum Sex {
        MALE, FEMALE
    }


    int getAge() {
        return age;
    }

/*    void printPerson(List<Person> roster, CheckPerson checker) {


        for (Person p : roster) {

            if (checker.checkperson(p))
                System.out.println(p.name);
        }
    }*/
    void printPerson(List<Person> roster, Predicate<Person> predicate) {


        for (Person p : roster) {

            if (predicate.test(p))
                System.out.println(p.name);
        }
    }
}