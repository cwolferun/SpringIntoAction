package com.EmployeeData;

import com.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class EmployeeTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    public void addEmployee(){
        Employee testEmployee = new Employee();
        testEmployee.setName("Bob");
        testEmployee.setAge(30);
        testEmployee.setCity("Denver");
        testEmployee.setState("PA");
        testEmployee.setSalary(6000000);
        testEmployee.setDepartment("FN");
        testEmployee.setLdap("xxbobxx");

        employeeService.save(testEmployee);


    }
}
