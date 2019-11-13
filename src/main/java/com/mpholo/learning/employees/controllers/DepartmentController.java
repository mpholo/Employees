package com.mpholo.learning.employees.controllers;

import com.mpholo.learning.employees.models.Department;
import com.mpholo.learning.employees.services.DepartmentService;
import com.mpholo.learning.employees.util.AttributeNames;
import com.mpholo.learning.employees.util.DepartmentMappings;
import com.mpholo.learning.employees.util.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(DepartmentMappings.ALL_DEPARTMENTS)
    public String displayDepartments(Model model) {
        List<Department> departments= departmentService.findAll();
        log.info("fetched {} departments",departments.size());
        model.addAttribute(AttributeNames.DEPARTMENT_LIST,departments);
        return ViewNames.ALL_DEPARTMENTS;
    }

    @GetMapping(DepartmentMappings.NEW_DEPARTMENT)
    public String addEditNew(@RequestParam(required = false,defaultValue = "-1") String dept_no, Model model) {

        log.info("Editing department with dept_no {}",dept_no);
        Department department = departmentService.findById(dept_no);
        if(department==null) {
            department = new Department();
        }

        model.addAttribute(AttributeNames.DEPARTMENT,new Department());
        return ViewNames.EDIT_DEPARTMENTS;
    }

    @PostMapping(DepartmentMappings.SAVE_DEPARTMENT)
    public String saveDepartment(@ModelAttribute(AttributeNames.DEPARTMENT) Department department) {

        log.info("Department from form = {}",department);
        departmentService.save(department);

         return "redirect:"+DepartmentMappings.ALL_DEPARTMENTS;
    }
}
