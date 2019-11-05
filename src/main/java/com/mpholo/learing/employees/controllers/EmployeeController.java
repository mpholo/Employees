package com.mpholo.learing.employees.controllers;

import com.mpholo.learing.employees.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("/list")
    public String showAll(Model model) {
        model.addAttribute("employees",employeeService.findAll());
        log.info("display all employees");
        return "/employees/showall";
    }
}
