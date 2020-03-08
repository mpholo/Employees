package com.mpholo.learning.employees.services;

import com.mpholo.learning.employees.bootstrap.EmployeeBootstrap;
import com.mpholo.learning.employees.models.Employee;
import com.mpholo.learning.employees.repositories.DepartmentRepository;
import com.mpholo.learning.employees.repositories.EmployeeRepository;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@DataJpaTest
class EmployeeServiceImplITTest {

    List<Employee> employees;
    Employee employee;
    int counter;
    long empNo;
    String firstName;


    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @BeforeClass
    void init() {




    }

    @BeforeEach
    void setUp() throws Exception {

        System.out.println("Loading Data");
        System.out.println(employeeRepository.findAll().size());

        EmployeeBootstrap bootstrap = new EmployeeBootstrap(departmentRepository,employeeRepository);
        bootstrap.run();

        employeeService = new EmployeeServiceImpl(employeeRepository);
        EmployeesInit();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findByFirstNameAndLastName() {

        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();

        List<Employee> searchedEmployee=employeeService.findByFirstNameAndLastName(firstName,lastName);
        assertThat(searchedEmployee.size(),not(equalTo(0)));

    }

    @Test
    void findById() {

        Employee employeeFromService = employeeService.findById(empNo);

       assertThat(empNo,equalTo(employeeFromService.getEmpNo()));

    }

    @Test
    void testfindAll() {

        List<Employee> employeeList = employeeService.findAll();
        assertNotNull(employeeList);
        assertThat(employeeList.size(),equalTo(counter));
    }

    @Test
    void deleteById() {


        employeeService.deleteById(empNo);
        assertThat(employeeService.findAll().size(),equalTo(counter-1));
    }

    @Test
    void delete() {

        employeeService.delete(employee);
        assertThat(employeeService.findAll().size(),equalTo(counter-1));
    }

    @Test
    void save() {

        Long newEmpNo =99999L;
        Employee employee = new Employee();
        employee.setEmpNo(newEmpNo);
        employee.setLastName("Leboea");
        employee.setFirstName("Mpholo");
        employee.setBirthDate(LocalDate.of(1981,Month.JULY,23));

        employeeService.save(employee);
        assertThat(employeeService.findAll().size(),equalTo(counter+1));

    }

    private void EmployeesInit() {
        System.out.println("Number of Employees: "+employeeRepository.findAll().size());

        employees = employeeService.findAll();
        empNo = employees.get(0).getEmpNo();
        counter = employees.size();
        employee = employees.get(0);

    }
}