package com.mpholo.learning.employees.services;

import com.mpholo.learning.employees.models.DeptEmp;
import com.mpholo.learning.employees.models.EmpDeptRelationIdentity;
import com.mpholo.learning.employees.repositories.DeptEmpRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.LongStream;

public interface DeptEmpService {

    List<DeptEmp> findByEmpDeptRelationDeptNo(String deptNo);
    Optional<DeptEmp> findByEmpDeptRelation(EmpDeptRelationIdentity empDeptRelationIdentity);
}
