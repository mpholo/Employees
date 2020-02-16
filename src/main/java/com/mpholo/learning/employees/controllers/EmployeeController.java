package com.mpholo.learning.employees.controllers;

import com.mpholo.learning.employees.models.Employee;
import com.mpholo.learning.employees.models.Title;
import com.mpholo.learning.employees.services.EmployeeService;
import com.mpholo.learning.employees.services.TitleService;
import com.mpholo.learning.employees.util.AttributeNames;
import com.mpholo.learning.employees.util.EmployeeMappings;
import com.mpholo.learning.employees.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@Controller

public class EmployeeController {

    private final EmployeeService employeeService;
    private final TitleService titleService;


    @ResponseBody
    @GetMapping("hello")
    public String hello() {
        log.info("Hello method called");
        return "Hello World from Employee Application";
    }

    public EmployeeController(EmployeeService employeeService, TitleService titleService) {
        this.employeeService = employeeService;
        this.titleService = titleService;
    }

    @GetMapping(EmployeeMappings.ALL_EMPLOYEES)
    public String showAll(Model model) {

        model.addAttribute(AttributeNames.EMPLOYEE_LIST,employeeService.findAll());
        log.info("displaying all employees");
        return ViewNames.ALL_EMPLOYEES;
    }

    @GetMapping(EmployeeMappings.EMPLOYEE_DETAILS)
    public String employeeDetails(@RequestParam(name="empNo") String empNo, Model model) {

        Employee employee= employeeService.findById(Long.valueOf(empNo));
        model.addAttribute(AttributeNames.EMPLOYEE,employee);

        return ViewNames.EMPLOYEE_DETAILS;
    }
}
