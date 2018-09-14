package com.company.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Playstream {


    public static void main(String[] args) {
        Stream<String> myStrings = Stream.of("this","is","a","stream");
        Comparator<String> comparator = (string1,string2)->{
            if(string1.length()>string2.length())return 1;
            if(string1.length()==string2.length())return 0;
            if(string1.length()<string2.length())return -1;
            return 0;
        };
        List<String> newStrings = myStrings.sorted(comparator).collect(Collectors.toList());
        myStrings.forEach(System.out::println);
        newStrings.forEach(System.out::println);

    }
}
