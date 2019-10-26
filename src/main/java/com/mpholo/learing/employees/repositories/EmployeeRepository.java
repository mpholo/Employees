package com.mpholo.learing.employees.repositories;

import com.mpholo.learing.employees.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Long, Employee> {

    List<Employee> findByFirstNameAndLastName(String firstName,String lastName);

}
