package com.mpholo.learning.employees.controllers;

import com.mpholo.learning.employees.services.EmployeeService;
import com.mpholo.learning.employees.util.AttributeNames;
import com.mpholo.learning.employees.util.EmployeeMappings;
import com.mpholo.learning.employees.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.management.Attribute;

@Slf4j
@Controller

public class EmployeeController {

    private final EmployeeService employeeService;


    @ResponseBody
    @GetMapping("hello")
    public String hello() {
        log.info("Hello method called");
        return "Hello World from Employee Application";
    }

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(EmployeeMappings.ALL_EMPLOYEES)
    public String showAll(Model model) {

        model.addAttribute(AttributeNames.EMPLOYEE_LIST,employeeService.findAll());
        log.info("displaying all employees");
        return ViewNames.ALL_EMPLOYEES;
    }
}
