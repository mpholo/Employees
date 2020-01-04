package com.mpholo.learning.employees.repositories;

import com.mpholo.learning.employees.models.DeptManager;
import com.mpholo.learning.employees.models.EmpDeptRelationIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeptManagerRepository extends JpaRepository<DeptManager, EmpDeptRelationIdentity> {

    List<DeptManager> findByEmpDeptRelationDeptNo(String deptNo);
}
