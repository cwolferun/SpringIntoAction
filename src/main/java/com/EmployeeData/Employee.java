package com.EmployeeData;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "employee")
@ToString @AllArgsConstructor @NoArgsConstructor @Getter @Setter
class Employee {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @Column(name = "eid")
    private UUID id;

    private String name;
    private int age;
    private String city;
    private String state;
    private int salary;
    private String department;
    private String ldap;

}
