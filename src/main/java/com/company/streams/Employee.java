package com.company.streams;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @AllArgsConstructor @ToString
class Employee {
    private String name;
    private String dept;
    private int salaryInCents;

    void printName(){
        System.out.println(name);
    }
}
