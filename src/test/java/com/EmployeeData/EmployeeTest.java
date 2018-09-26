package com.EmployeeData;

import com.Main;
import org.apache.catalina.startup.UserConfig;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = Main.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = { EmployeeConfig.class })
public class EmployeeTest {

    @Autowired
    EmployeeService employeeService;

    @Test
    @Transactional("cloudTransactionManager")
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

        Employee newGuy = employeeService.findEmployeeByLdap("xxbobxx");

        Assert.assertEquals("did the push and pull","Bob",newGuy.getName());

    }
}
