package com.mpholo.learning.employees.repositories;

import com.mpholo.learning.employees.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,String> {


}
