package com.mpholo.learning.employees.services;

import com.mpholo.learning.employees.DTO.TitleDTO;
import com.mpholo.learning.employees.models.Employee;
import com.mpholo.learning.employees.models.Title;

import java.util.List;

public interface TitleService {

    List<TitleDTO>  findTitleByEmployee(Employee employee);

}
