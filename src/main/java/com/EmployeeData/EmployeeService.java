package com.EmployeeData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeService  extends JpaRepository<Employee, UUID> {

    Employee getDistinctByLdap(String ldap);
    }
