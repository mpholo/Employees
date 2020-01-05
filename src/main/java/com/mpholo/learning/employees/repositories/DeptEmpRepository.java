package com.mpholo.learning.employees.repositories;

import com.mpholo.learning.employees.models.DeptEmp;
import com.mpholo.learning.employees.models.EmpDeptRelationIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeptEmpRepository extends JpaRepository<DeptEmp, EmpDeptRelationIdentity> {

    List<DeptEmp> findByEmpDeptRelationDeptNo(String deptNo);
    Optional<DeptEmp> findByEmpDeptRelation(EmpDeptRelationIdentity empDeptRelationIdentity);


}
