package miscExamples;

import java.util.ArrayList;
import java.util.List;

public class PersonLambdas {



    public static void main(String[] args){
        Person person = new Person(45,"Bob", Person.Sex.MALE );

        Person person1 = new Person(5,"Bob1", Person.Sex.MALE );
        Person person2 = new Person(25,"Bob2", Person.Sex.MALE );
        Person person3 = new Person(75,"Bob3", Person.Sex.FEMALE );

        List<Person> people = new ArrayList<>();

        people.add(person1);
        people.add(person2);
        people.add(person3);

        person.printPerson(people, (Person p) -> p.getGender() == Person.Sex.MALE
                && p.getAge() >= 18
                && p.getAge() <= 25);
    }
}
