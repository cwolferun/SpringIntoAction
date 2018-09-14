package com.company.lamdas;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Playground {

    @FunctionalInterface
    interface  Play{
        String goplay(String string);
    }

    @FunctionalInterface
    interface NewPlay{
        UnaryOperator<String> goplay(String string);
    }

    public static void main(String[] args) {
        Play play = s->s+" from lambda";
        UnaryOperator<String> newPlay = s->s+" from new lambda";
//        String madeup = "here i am";
        Predicate<String> check = s -> s.startsWith("here");
        String result = play.goplay("here i am");
        String result2 = newPlay.apply("here I am again");
        System.out.println(result);
        System.out.println(result2);
        System.out.println(check.test(result));

    }
}
