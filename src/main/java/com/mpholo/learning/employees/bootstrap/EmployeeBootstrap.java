package com.mpholo.learning.employees.bootstrap;

import com.mpholo.learning.employees.models.Department;
import com.mpholo.learning.employees.models.Employee;
import com.mpholo.learning.employees.repositories.DepartmentRepository;
import com.mpholo.learning.employees.repositories.EmployeeRepository;
import com.mpholo.learning.employees.services.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.EventListener;
import java.util.List;

@Slf4j
@Component
public class EmployeeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    DepartmentRepository departmentRepository;
    EmployeeRepository employeeRepository;

    public EmployeeBootstrap(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
       List<Department> departments = departmentRepository.findAll();
       departmentRepository.saveAll(departments);

       List<Employee> employees = employeeRepository.findAll();
       employeeRepository.saveAll(employees);
    }
}
