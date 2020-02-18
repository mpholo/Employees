package com.mpholo.learning.employees.controllers;

import com.mpholo.learning.employees.models.Department;
import com.mpholo.learning.employees.models.DeptEmp;
import com.mpholo.learning.employees.models.DeptManager;
import com.mpholo.learning.employees.repositories.DeptEmpRepository;
import com.mpholo.learning.employees.repositories.DeptManagerRepository;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Controller
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DeptManagerRepository deptManagerRepository;
    private final DeptEmpRepository deptEmpRepository;

    @Autowired
    public DepartmentController(DepartmentService departmentService, DeptManagerRepository deptManagerRepository,
                                DeptEmpRepository deptEmpRepository) {
        this.departmentService = departmentService;
        this.deptManagerRepository = deptManagerRepository;
        this.deptEmpRepository = deptEmpRepository;
    }

    @GetMapping({DepartmentMappings.ALL_DEPARTMENTS,"departments"})
    public String displayDepartments(Model model,
                                     @RequestParam(name = "operation",required = false) String operation) {
        List<Department> departments= departmentService.findAll();
        log.info("fetching all departments");

        model.addAttribute(AttributeNames.DEPARTMENT_LIST,departments);
        model.addAttribute(AttributeNames.DEPARTMENT_OPERATION,operation);

        return ViewNames.ALL_DEPARTMENTS;
    }

    @GetMapping(DepartmentMappings.NEW_DEPARTMENT)
    public String addEditNew(@RequestParam(name = "deptNo",required = false,defaultValue = "-1") String deptNo,
                             @RequestParam(name="operation",required=false,defaultValue = "add") String operation ,Model model
                               ) {
        Department department = departmentService.findById(deptNo);
        if(department==null) {
            log.info("Creating new department");
            department = new Department();
        }

        model.addAttribute(AttributeNames.DEPARTMENT,department);
        model.addAttribute(AttributeNames.DEPARTMENT_OPERATION,operation);
        return ViewNames.EDIT_DEPARTMENTS;
    }

    @PostMapping(DepartmentMappings.SAVE_DEPARTMENT)
    public String saveDepartment(@ModelAttribute(AttributeNames.DEPARTMENT) Department department,
                                 @ModelAttribute(AttributeNames.DEPARTMENT_OPERATION) String operation) {


        departmentService.save(department);
        log.info("Department from form = {} saved successfully",department);
         return "redirect:"+DepartmentMappings.ALL_DEPARTMENTS+"?operation="+operation;
    }

    @GetMapping(DepartmentMappings.DELETE_DEPARTMENT)
    public String deleteDepartment(@RequestParam(name="deptNo") String deptNo) {
        log.info("Deleting Department  with deptNo {}",deptNo);
        departmentService.deleteById(deptNo);


        return "redirect:"+DepartmentMappings.ALL_DEPARTMENTS+"?operation=deleted";
    }

    @GetMapping(DepartmentMappings.DEPARTMENT_DETAILS)
    public String departmentDetails(@RequestParam(name="deptNo") String deptNo,Model model) {

        Department department = departmentService.findById(deptNo);
        model.addAttribute(AttributeNames.DEPARTMENT,department);

        //sort deptManager list by fromDate in descending order
        List<DeptManager> deptManagers = deptManagerRepository.findByEmpDeptRelationDeptNo(deptNo)
                                         .stream().sorted((a,b)->b.getPeriod().getFromDate().compareTo(a.getPeriod().getFromDate()))
                                         .collect(Collectors.toList());

        model.addAttribute(AttributeNames.DEPT_MANAGER_LIST,deptManagers);

        //show employees for department
        List<DeptEmp> deptEmp = deptEmpRepository.findByEmpDeptRelationDeptNo(deptNo);
        model.addAttribute(AttributeNames.DEPT_EMP_LIST,deptEmp);

        //==counters==
        model.addAttribute(AttributeNames.DEPT_EMP_COUNT,deptEmp.size());
        model.addAttribute(AttributeNames.DEPT_MANAGER_COUNT,deptManagers.size());

        return ViewNames.DEPARTMENT_DETAILS;

    }
}
