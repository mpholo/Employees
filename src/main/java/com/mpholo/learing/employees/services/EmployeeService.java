package com.mpholo.learing.employees.services;

import com.mpholo.learing.employees.models.Employee;

import java.util.List;

public interface EmployeeService extends CrudService<Employee,Long> {

    List<Employee> findByfastNameAndLastName(String firstName, String lastName);
}
