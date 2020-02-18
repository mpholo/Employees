package com.mpholo.learning.employees.controllers;

import com.mpholo.learning.employees.models.Department;
import com.mpholo.learning.employees.repositories.DeptEmpRepository;
import com.mpholo.learning.employees.repositories.DeptManagerRepository;
import com.mpholo.learning.employees.services.DepartmentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mpholo.learning.employees.util.AttributeNames.*;
import static com.mpholo.learning.employees.util.ViewNames.ALL_DEPARTMENTS;
import static com.mpholo.learning.employees.util.ViewNames.EDIT_DEPARTMENTS;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class DepartmentControllerTest {

    @Mock
    DepartmentService departmentService;

    @Mock
    DeptEmpRepository deptEmpRepository;

    @Mock
    DeptManagerRepository deptManagerRepository;

    @Mock
    Model model;

    final String deptNo="dept1";


    final String operation="";


    DepartmentController departmentController;


    @BeforeEach
    void setUp() {

        MockitoAnnotations.initMocks(this);

        departmentController = new DepartmentController(departmentService,deptManagerRepository,deptEmpRepository);

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void displayDepartmentsTest() {


        //given
        List<Department> departmentList =  Arrays.asList(new Department(),new Department(),new Department());
        when(departmentService.findAll()).thenReturn(departmentList);

        ArgumentCaptor<List<Department>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        //when
        String viewName = departmentController.displayDepartments(model,operation);

        //then
        assertThat(ALL_DEPARTMENTS,is(equalTo(viewName)));
        verify(departmentService,times(1)).findAll();
        verify(model,times(1)).addAttribute(eq(DEPARTMENT_LIST),argumentCaptor.capture());
        List<Department> setInController = argumentCaptor.getValue();
        assertThat(3,is(equalTo(setInController.size())));
        verify(model,times(1)).addAttribute(eq(DEPARTMENT_OPERATION),any());




    }

    @Test
    void addEditNew() {


        Department department = new Department();
        department.setDeptNo(deptNo);

        when(departmentService.findById(deptNo)).thenReturn(department);

        String viewName = departmentController.addEditNew(deptNo,operation,model);
        assertThat(EDIT_DEPARTMENTS,is(equalTo(viewName)));




    }

    @Test
    void saveDepartment() {
    }

    @Test
    void deleteDepartment() {
    }

    @Test
    void departmentDetails() {
    }
}