package com.mpholo.learing.employees.controllers;

import com.mpholo.learing.employees.models.Department;
import com.mpholo.learing.employees.services.DepartmentService;
import com.mpholo.learing.employees.util.AttributeNames;
import com.mpholo.learing.employees.util.EmployeeMappings;
import com.mpholo.learing.employees.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping({"/showall","","/"})
    public String displayDepartments(Model model) {
        List<Department> departments= departmentService.findAll();
        log.info("fetched {} departments",departments.size());
        model.addAttribute(AttributeNames.DEPARTMENT_LIST,departments);
        return ViewNames.ALL_DEPARTMENTS;
    }
}
