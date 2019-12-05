package com.mpholo.learning.employees.services;

import com.mpholo.learning.employees.models.Employee;

import java.util.List;

public interface EmployeeService extends CrudService<Employee,Long> {

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
}
