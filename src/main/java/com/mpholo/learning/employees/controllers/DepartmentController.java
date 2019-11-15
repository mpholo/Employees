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
    public String addEditNew(@RequestParam(name = "deptNo",required = false,defaultValue = "-1") String deptNo, Model model) {


        Department department = departmentService.findById(deptNo);
        if(department==null) {
            log.info("Creating new department");
            department = new Department();
        }

        log.info("Editing department with dept_no {}",department.getDeptNo());
        model.addAttribute(AttributeNames.DEPARTMENT,department);
        return ViewNames.EDIT_DEPARTMENTS;
    }

    @PostMapping(DepartmentMappings.SAVE_DEPARTMENT)
    public String saveDepartment(@ModelAttribute(AttributeNames.DEPARTMENT) Department department) {

        log.info("Department from form = {}",department);
        departmentService.save(department);

         return "redirect:"+DepartmentMappings.ALL_DEPARTMENTS;
    }

    @GetMapping(DepartmentMappings.DELETE_DEPARTMENT)
    public String deleteDepartment(@RequestParam(name="deptNo") String deptNo) {
        log.info("Deleting Department  with deptNo {}",deptNo);
        departmentService.deleteById(deptNo);

        return "redirect:"+DepartmentMappings.ALL_DEPARTMENTS;
    }
}
