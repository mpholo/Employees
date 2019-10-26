package com.mpholo.learing.employees.services;

import com.mpholo.learing.employees.models.Employee;
import com.mpholo.learing.employees.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findByfastNameAndLastName(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName,lastName);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);

    }

    @Override
    public void delete(Employee employee) {

        employeeRepository.delete(employee);

    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
