package com.mpholo.learning.employees.repositories;

import com.mpholo.learning.employees.models.Employee;
import com.mpholo.learning.employees.models.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TitleRepository extends JpaRepository<Title,Long> {

    List<Title> findTitleByEmployee(Employee employee);

}
