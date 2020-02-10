package com.mpholo.learning.employees.mapper;

import com.mpholo.learning.employees.DTO.TitleDTO;
import com.mpholo.learning.employees.models.Employee;
import com.mpholo.learning.employees.models.Period;
import com.mpholo.learning.employees.models.Title;
import com.mpholo.learning.employees.repositories.EmployeeRepository;
import com.mpholo.learning.employees.repositories.TitleRepository;
import com.mpholo.learning.employees.services.EmployeeService;
import com.mpholo.learning.employees.services.EmployeeServiceImpl;
import com.mpholo.learning.employees.services.TitleService;
import com.mpholo.learning.employees.services.TitleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TitleMapperTest {

    private final Long empNo =10017L;
    TitleService titleService;
    EmployeeService employeeService;

    @Mock
    TitleRepository titleRepository;

    @Mock
    EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        titleService = new TitleServiceImpl(TitleMapper.INSTANCE,titleRepository);
        employeeService = new EmployeeServiceImpl(employeeRepository);



    }

    @org.junit.jupiter.api.Test
    void titleToTitleDTO() {



    }
}