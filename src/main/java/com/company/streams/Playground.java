package com.company.streams;

import org.assertj.core.util.Arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Stream.of;

public class Playground {

    @FunctionalInterface
    interface Play {
        String goplay(String string);
    }

    @FunctionalInterface
    interface NewPlay {
        UnaryOperator<String> goplay(String string);
    }


    public static void main(String[] args) {
        test4();

    }


    void test1() {

        Predicate<String> check = s -> s.startsWith("here");
        Play play = s -> s + " from lambda";
        UnaryOperator<String> newPlay = s -> s + " from new lambda";

        String result = play.goplay("here i am");
        String result2 = newPlay.apply("here I am again");

        System.out.println(result);
        System.out.println(result2);
        System.out.println(check.test(result));

    }

    void test2() {

        String longArray[] = "I ride and I eat the pudding slides you see?".split(" ");
        UnaryOperator<String> addWord = text -> {
            return text + " hey";
        };
        Comparator<String> longest = (string1, string2) -> {
            if (string1.length() >= string2.length()) return 1;
            if (string1.length() == string2.length()) return 0;
            if (string1.length() <= string2.length()) return -1;
            return 0;
        };
        //   IntSupplier someInts = ()->{ return (int) (Math.random()*15);};

        Stream<String> stringStream = Stream.of(longArray);
        stringStream.sorted(longest).map(addWord).forEach(System.out::println);
//        stringStream.sorted(longest).map(addWord).collect(Co)
    }

    static void test3() {
        Consumer<String> consumer1 = (arg) -> {
            System.out.println(arg + "OK");
        };
        consumer1.accept("TestConsumerAccept - ");
        Consumer<String> consumer2 = (x) -> {
            System.out.println(x + "OK!!!");
        };
        consumer1.andThen(consumer2).accept("TestConsumerAfterThen - ");
    }

    static void test4() {
        Stream<Employee> employeeStream = Stream.of(new Employee("bill", "finance", 400),
                new Employee("billiam", "design", 400), new Employee("bob", "legal", 400),
                new Employee("bob", "legal", 400), new Employee("bob", "finance", 400));


//        Map<String, List<Employee>> groupedByDep = employeeStream.collect(Collectors.groupingBy(Employee::getDept));
//
//        groupedByDep.forEach((key, val) -> {
//            val.forEach(System.out::println);
//        });

        Map<String, Integer> totalByDept
                = employeeStream.collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.summingInt(Employee::getSalaryInCents)));
        totalByDept.forEach((key,val)-> System.out.println(key + " "+val));

        /*
        Employee(name=billiam, dept=design, salaryInCents=400)
        Employee(name=bob, dept=legal, salaryInCents=400)
        Employee(name=bob, dept=legal, salaryInCents=400)
        Employee(name=bill, dept=finance, salaryInCents=400)
        Employee(name=bob, dept=finance, salaryInCents=400)
        */

    }


}
