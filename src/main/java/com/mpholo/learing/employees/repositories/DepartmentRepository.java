package com.mpholo.learing.employees.repositories;

import com.mpholo.learing.employees.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,String> {


}
